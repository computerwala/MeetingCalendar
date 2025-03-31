//package com.calendar.calendar_meeting.service;
//
//import com.calendar.calendar_meeting.dto.MeetingRequest;
//import com.calendar.calendar_meeting.entity.Employee;
//import com.calendar.calendar_meeting.entity.Meeting;
//import com.calendar.calendar_meeting.entity.TimeSlot;
//import com.calendar.calendar_meeting.exception.CalendarException;
//import com.calendar.calendar_meeting.impl.MeetingServiceImpl;
//import com.calendar.calendar_meeting.repository.CalendarRepository;
//import com.calendar.calendar_meeting.repository.EmployeeRepository;
//import com.calendar.calendar_meeting.repository.MeetingRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class MeetingServiceTest {
//
//    @Mock
//    private MeetingRepository meetingRepository;
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @Mock
//    private CalendarRepository calendarRepository;
//
//    @InjectMocks
//    private MeetingServiceImpl meetingService;
//
//    private MeetingRequest meetingRequest;
//    private Employee organizer;
//    private Calendar calendar;
//
//    @BeforeEach
//    void setUp() {
//        organizer = new Employee();
//        organizer.setId(1L);
//        organizer.setName("Organizer");
//        organizer.setEmail("organizer@example.com");
//
//        calendar = new Calendar();
//        calendar.setId(1L);
//        // Set the employee using the proper setter method in Calendar class
//        calendar.setEmployee(organizer);
//
//        meetingRequest = new MeetingRequest();
//        meetingRequest.setTitle("Test Meeting");
//        meetingRequest.setOrganizerId(1L);
//        meetingRequest.setTimeSlot(new TimeSlot(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)));
//        meetingRequest.setParticipantIds(Set.of(2L));
//    }
//
//    @Test
//    void scheduleMeeting_ValidRequest_ReturnsScheduledMeeting() {
//        // Arrange
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(organizer));
//        when(calendarRepository.findByEmployeeId(1L)).thenReturn(Optional.of(calendar));
//        when(meetingRepository.save(any(Meeting.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Act
//        Meeting scheduledMeeting = meetingService.scheduleMeeting(meetingRequest);
//
//        // Assert
//        assertNotNull(scheduledMeeting);
//        assertEquals("Test Meeting", scheduledMeeting.getTitle());
//    }
//
//    @Test
//    void scheduleMeeting_InvalidOrganizerId_ThrowsException() {
//        // Arrange
//        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act/Assert
//        assertThrows(CalendarException.class, () -> meetingService.scheduleMeeting(meetingRequest));
//    }
//
//    @Test
//    void findConflicts_NoConflicts_ReturnsEmptyMap() {
//        // Arrange
//        when(meetingRepository.findOverlappingMeetings(any(), any(), any())).thenReturn(new ArrayList<>());
//
//        // Act
//        Map<Long, List<Meeting>> conflicts = meetingService.findConflicts(meetingRequest);
//
//        // Assert
//        assertTrue(conflicts.isEmpty());
//    }
//
//    @Test
//    void findConflicts_ConflictsExist_ReturnsConflictsMap() {
//        // Arrange
//        List<Meeting> conflictList = new ArrayList<>();
//        Meeting conflict = new Meeting();
//        conflict.setTitle("Conflicting Meeting");
//        conflictList.add(conflict);
//
//        when(meetingRepository.findOverlappingMeetings(any(), any(), any())).thenReturn(conflictList);
//
//        // Act
//        Map<Long, List<Meeting>> conflicts = meetingService.findConflicts(meetingRequest);
//
//        // Assert
//        assertFalse(conflicts.isEmpty());
//    }
//}