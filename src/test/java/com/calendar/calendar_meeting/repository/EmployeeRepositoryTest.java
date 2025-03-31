//package com.calendar.calendar_meeting.repository;
//
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
//public class EmployeeRepositoryTest {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    void findByEmail_ExistingEmail_ReturnsEmployee() {
//        // Arrange
//        Employee employee = new Employee();
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//        entityManager.persist(employee);
//        entityManager.flush();
//
//        // Act
//        Optional<Employee> foundEmployee = employeeRepository.findByEmail("test@example.com");
//
//        // Assert
//        assertTrue(foundEmployee.isPresent());
//        assertEquals("Test Employee", foundEmployee.get().getName());
//    }
//
//    @Test
//    void findByEmail_NonExistingEmail_ReturnsEmpty() {
//        // Arrange/Act
//        Optional<Employee> foundEmployee = employeeRepository.findByEmail("nonexistent@example.com");
//
//        // Assert
//        assertTrue(foundEmployee.isEmpty());
//    }
//}