package com.calendar.calendar_meeting.impl;

import com.calendar.calendar_meeting.entity.Meeting;
import com.calendar.calendar_meeting.entity.TimeSlot;
import com.calendar.calendar_meeting.repository.MeetingRepository;
import com.calendar.calendar_meeting.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public CalendarServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public List<TimeSlot> findFreeSlots(Long employeeId1, Long employeeId2, int durationMinutes) {
        List<Meeting> meetings1 = meetingRepository.findByCalendarEmployeeId(employeeId1);
        List<Meeting> meetings2 = meetingRepository.findByCalendarEmployeeId(employeeId2);

        List<TimeSlot> busySlots = new ArrayList<>();
        meetings1.forEach(meeting -> busySlots.add(meeting.getTimeSlot()));
        meetings2.forEach(meeting -> busySlots.add(meeting.getTimeSlot()));
        busySlots.sort(Comparator.comparing(TimeSlot::getStartTime));

        LocalDate today = LocalDate.now();
        LocalDateTime workStart = LocalDateTime.of(today, LocalTime.of(9, 0));
        LocalDateTime workEnd = LocalDateTime.of(today, LocalTime.of(17, 0));

        List<TimeSlot> freeSlots = new ArrayList<>();
        LocalDateTime currentTime = workStart;

        for (TimeSlot busy : busySlots) {
            if (busy.getStartTime().isAfter(currentTime)) {
                TimeSlot freeSlot = new TimeSlot(currentTime, busy.getStartTime());
                if (freeSlot.getDurationInMinutes() >= durationMinutes) {
                    freeSlots.add(freeSlot);
                }
            }

            if (busy.getEndTime().isAfter(currentTime)) {
                currentTime = busy.getEndTime();
            }
        }

        if (currentTime.isBefore(workEnd)) {
            TimeSlot freeSlot = new TimeSlot(currentTime, workEnd);
            if (freeSlot.getDurationInMinutes() >= durationMinutes) {
                freeSlots.add(freeSlot);
            }
        }

        return freeSlots;
    }
}
