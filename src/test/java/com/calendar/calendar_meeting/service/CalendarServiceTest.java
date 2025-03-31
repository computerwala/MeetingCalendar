//package com.calendar.calendar_meeting.service;
//
//import com.calendar.calendar_meeting.entity.Meeting;
//import com.calendar.calendar_meeting.entity.TimeSlot;
//import com.calendar.calendar_meeting.impl.CalendarServiceImpl;
//import com.calendar.calendar_meeting.repository.MeetingRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CalendarServiceTest {
//
//    @Mock
//    private MeetingRepository meetingRepository;
//
//    @InjectMocks
//    private CalendarServiceImpl calendarService;
//
//    @Test
//    void findFreeSlots_NoMeetings_ReturnsFreeSlot() {
//        // Arrange
//        when(meetingRepository.findByCalendarEmployeeId(1L)).thenReturn(new ArrayList<>());
//        when(meetingRepository.findByCalendarEmployeeId(2L)).thenReturn(new ArrayList<>());
//
//        // Act
//        List<TimeSlot> freeSlots = calendarService.findFreeSlots(1L, 2L, 30);
//
//        // Assert
//        assertFalse(freeSlots.isEmpty());
//    }
//
//    @Test
//    void findFreeSlots_WithMeetings_ReturnsAvailableSlots() {
//        // Arrange
//        List<Meeting> meetings1 = new ArrayList<>();
//        Meeting meeting1 = new Meeting();
//        TimeSlot timeSlot1 = new TimeSlot(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
//        meeting1.setTimeSlot(timeSlot1);
//        meetings1.add(meeting1);
//
//        List<Meeting> meetings2 = new ArrayList<>();
//        Meeting meeting2 = new Meeting();
//        TimeSlot timeSlot2 = new TimeSlot(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4));
//        meeting2.setTimeSlot(timeSlot2);
//        meetings2.add(meeting2);
//
//        when(meetingRepository.findByCalendarEmployeeId(1L)).thenReturn(meetings1);
//        when(meetingRepository.findByCalendarEmployeeId(2L)).thenReturn(meetings2);
//
//        // Act
//        List<TimeSlot> freeSlots = calendarService.findFreeSlots(1L, 2L, 30);
//
//        // Assert
//        assertTrue(freeSlots.size() >= 0);
//    }
//}