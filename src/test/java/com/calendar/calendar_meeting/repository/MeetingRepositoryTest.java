//package com.calendar.calendar_meeting.repository;
//
//import com.calendar.calendar_meeting.entity.Calendar;
//import com.calendar.calendar_meeting.entity.Employee;
//import com.calendar.calendar_meeting.entity.Meeting;
//import com.calendar.calendar_meeting.entity.TimeSlot;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class MeetingRepositoryTest {
//
//    @Autowired
//    private MeetingRepository meetingRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    void findOverlappingMeetings_OverlappingMeetingsExist_ReturnsMeetings() {
//        // Arrange
//        Employee employee = new Employee();
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//        entityManager.persist(employee);
//
//        Calendar calendar = new Calendar();
//        calendar.setEmployee(employee);
//        entityManager.persist(calendar);
//
//        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
//
//        Meeting meeting = new Meeting();
//        meeting.setTitle("Test Meeting");
//        meeting.setTimeSlot(timeSlot);
//        meeting.setCalendar(calendar);
//        entityManager.persist(meeting);
//        entityManager.flush();
//
//        // Act
//        List<Meeting> overlappingMeetings = meetingRepository.findOverlappingMeetings(
//                employee.getId(),
//                LocalDateTime.now().plusHours(1).plusMinutes(30),
//                LocalDateTime.now().plusHours(2).plusMinutes(30)
//        );
//
//        // Assert
//        assertFalse(overlappingMeetings.isEmpty());
//        assertEquals("Test Meeting", overlappingMeetings.get(0).getTitle());
//    }
//
//    @Test
//    void findOverlappingMeetings_NoOverlappingMeetings_ReturnsEmptyList() {
//        // Arrange
//        Employee employee = new Employee();
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//        entityManager.persist(employee);
//
//        Calendar calendar = new Calendar();
//        calendar.setEmployee(employee);
//        entityManager.persist(calendar);
//
//        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4));
//
//        Meeting meeting = new Meeting();
//        meeting.setTitle("Test Meeting");
//        meeting.setTimeSlot(timeSlot);
//        meeting.setCalendar(calendar);
//        entityManager.persist(meeting);
//        entityManager.flush();
//
//        // Act
//        List<Meeting> overlappingMeetings = meetingRepository.findOverlappingMeetings(
//                employee.getId(),
//                LocalDateTime.now().plusHours(1),
//                LocalDateTime.now().plusHours(2)
//        );
//
//        // Assert
//        assertTrue(overlappingMeetings.isEmpty());
//    }
//}