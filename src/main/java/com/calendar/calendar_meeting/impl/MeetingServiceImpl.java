package com.calendar.calendar_meeting.impl;

import com.calendar.calendar_meeting.dto.MeetingRequest;
import com.calendar.calendar_meeting.entity.Calendar;
import com.calendar.calendar_meeting.entity.Employee;
import com.calendar.calendar_meeting.entity.Meeting;
import com.calendar.calendar_meeting.exception.CalendarException;
import com.calendar.calendar_meeting.repository.CalendarRepository;
import com.calendar.calendar_meeting.repository.EmployeeRepository;
import com.calendar.calendar_meeting.repository.MeetingRepository;
import com.calendar.calendar_meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;
    private final EmployeeRepository employeeRepository;
    private final CalendarRepository calendarRepository;

    @Autowired
    public MeetingServiceImpl(MeetingRepository meetingRepository, EmployeeRepository employeeRepository, CalendarRepository calendarRepository) {
        this.meetingRepository = meetingRepository;
        this.employeeRepository = employeeRepository;
        this.calendarRepository = calendarRepository;
    }

    @Override
    @Transactional
    public Meeting scheduleMeeting(MeetingRequest meetingRequest) {
        Employee organizer = employeeRepository.findById(meetingRequest.getOrganizerId())
                .orElseThrow(() -> new CalendarException("Organizer not found with id: " + meetingRequest.getOrganizerId()));

        Calendar calendar = calendarRepository.findByEmployeeId(organizer.getId())
                .orElseThrow(() -> new CalendarException("Calendar not found for organizer with id: " + organizer.getId()));

        Meeting meeting = new Meeting();
        meeting.setTitle(meetingRequest.getTitle());
        meeting.setDescription(meetingRequest.getDescription());
        meeting.setTimeSlot(meetingRequest.getTimeSlot());
        meeting.setCalendar(calendar);

        if (meetingRequest.getParticipantIds() != null && !meetingRequest.getParticipantIds().isEmpty()) {
            Set<Employee> participants = employeeRepository.findAllById(meetingRequest.getParticipantIds()).stream()
                    .collect(Collectors.toSet());
            meeting.setParticipants(participants);
        }
        meeting = meetingRepository.save(meeting);

        calendar.getMeetings().add(meeting);
        calendarRepository.save(calendar);
        return meeting;
    }

    @Override
    public Map<Long, List<Meeting>> findConflicts(MeetingRequest meetingRequest) {
        Map<Long, List<Meeting>> conflicts = new HashMap<>();

        List<Meeting> organizerConflicts = meetingRepository.findOverlappingMeetings(
                meetingRequest.getOrganizerId(),
                meetingRequest.getTimeSlot().getStartTime(),
                meetingRequest.getTimeSlot().getEndTime());
        if (!organizerConflicts.isEmpty()) {
            conflicts.put(meetingRequest.getOrganizerId(), organizerConflicts);
        }

        if (meetingRequest.getParticipantIds() != null) {
            for (Long participantId : meetingRequest.getParticipantIds()) {
                List<Meeting> participantConflicts = meetingRepository.findOverlappingMeetings(
                        participantId,
                        meetingRequest.getTimeSlot().getStartTime(),
                        meetingRequest.getTimeSlot().getEndTime());
                if (!participantConflicts.isEmpty()) {
                    conflicts.put(participantId, participantConflicts);
                }
            }
        }

        return conflicts;
    }
}