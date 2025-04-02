//package com.calendar.calendar_meeting.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.calendar.calendar_meeting.entity.Employee;
//import com.calendar.calendar_meeting.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Arrays;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeServiceImpl employeeService;
//
//    private Employee sampleEmployee;
//
//    @BeforeEach
//    void setUp() {
//        sampleEmployee = new Employee();
//        sampleEmployee.setId(1L);
//        sampleEmployee.setName("John Doe");
//    }
//
//    @Test
//    void testFindEmployeeById_Success() {
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(sampleEmployee));
//
//        Employee foundEmployee = employeeService.findEmployeeById(1L);
//
//        assertNotNull(foundEmployee);
//        assertEquals(1L, foundEmployee.getId());
//        assertEquals("John Doe", foundEmployee.getName());
//        verify(employeeRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void testFindEmployeeById_NotFound() {
//        when(employeeRepository.findById(2L)).thenReturn(Optional.empty());
//
//        Employee foundEmployee = employeeService.findEmployeeById(2L);
//
//        assertNull(foundEmployee);
//        verify(employeeRepository, times(1)).findById(2L);
//    }
//
//    @Test
//    void testSaveEmployee() {
//        when(employeeRepository.save(any(Employee.class))).thenReturn(sampleEmployee);
//
//        Employee savedEmployee = employeeService.saveEmployee(sampleEmployee);
//
//        assertNotNull(savedEmployee);
//        assertEquals("John Doe", savedEmployee.getName());
//        verify(employeeRepository, times(1)).save(sampleEmployee);
//    }
//
//    @Test
//    void testGetAllEmployees() {
//        List<Employee> employees = Arrays.asList(sampleEmployee, new Employee(2L, "Jane Doe"));
//        when(employeeRepository.findAll()).thenReturn(employees);
//
//        List<Employee> result = employeeService.getAllEmployees();
//
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        verify(employeeRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testDeleteEmployeeById() {
//        doNothing().when(employeeRepository).deleteById(1L);
//
//        employeeService.deleteEmployeeById(1L);
//
//        verify(employeeRepository, times(1)).deleteById(1L);
//    }
//}
