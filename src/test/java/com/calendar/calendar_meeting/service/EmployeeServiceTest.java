//package com.calendar.calendar_meeting.service;
//
//import com.calendar.calendar_meeting.entity.Employee;
//import com.calendar.calendar_meeting.exception.CalendarException;
//import com.calendar.calendar_meeting.impl.EmployeeServiceImpl;
//import com.calendar.calendar_meeting.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeServiceImpl employeeService;
//
//    private Employee employee;
//
//    @BeforeEach
//    void setUp() {
//        employee = new Employee();
//        employee.setId(1L);
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//    }
//
//    @Test
//    void createEmployee_ValidInput_ReturnsCreatedEmployee() {
//        // Arrange
//        when(employeeRepository.findByEmail(employee.getEmail())).thenReturn(Optional.empty());
//        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
//
//        // Act
//        Employee createdEmployee = employeeService.createEmployee(employee);
//
//        // Assert
//        assertNotNull(createdEmployee);
//        assertEquals("Test Employee", createdEmployee.getName());
//    }
//
//    @Test
//    void createEmployee_DuplicateEmail_ThrowsException() {
//        // Arrange
//        when(employeeRepository.findByEmail(employee.getEmail())).thenReturn(Optional.of(employee));
//
//        // Act/Assert
//        assertThrows(CalendarException.class, () -> employeeService.createEmployee(employee));
//    }
//
//    @Test
//    void getEmployeeById_ExistingId_ReturnsEmployee() {
//        // Arrange
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
//
//        // Act
//        Optional<Employee> foundEmployee = employeeService.getEmployeeById(1L);
//
//        // Assert
//        assertTrue(foundEmployee.isPresent());
//        assertEquals("Test Employee", foundEmployee.get().getName());
//    }
//
//    @Test
//    void getEmployeeById_NonExistingId_ReturnsEmpty() {
//        // Arrange
//        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act
//        Optional<Employee> foundEmployee = employeeService.getEmployeeById(1L);
//
//        // Assert
//        assertFalse(foundEmployee.isPresent());
//    }
//}
//j