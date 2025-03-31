//package com.calendar.calendar_meeting.repository;
//
//import com.calendar.calendar_meeting.entity.Calendar;
//import com.calendar.calendar_meeting.entity.Employee;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//public class CalendarRepositoryTest {
//
//    @Autowired
//    private CalendarRepository calendarRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    void findByEmployeeId_ExistingEmployeeId_ReturnsCalendar() {
//        // Arrange
//        Employee employee = new Employee();
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//        entityManager.persist(employee);
//
//        Calendar calendar = new Calendar();
//        calendar.setEmployee(employee);
//        entityManager.persist(calendar);
//        entityManager.flush();
//
//        // Act
//        Optional<Calendar> foundCalendar = calendarRepository.findByEmployeeId(employee.getId());
//
//        // Assert
//        assertTrue(foundCalendar.isPresent());
//        assertEquals(employee.getId(), foundCalendar.get().getEmployee().getId());
//    }
//
//    @Test
//    void findByEmployeeId_NonExistingEmployeeId_ReturnsEmpty() {
//        // Arrange/Act
//        Optional<Calendar> foundCalendar = calendarRepository.findByEmployeeId(999L);
//
//        // Assert
//        assertTrue(foundCalendar.isEmpty());
//    }
//}
//
