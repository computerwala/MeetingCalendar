//package com.calendar.calendar_meeting.controller;
//
//import com.calendar.calendar_meeting.entity.Employee;
//import com.calendar.calendar_meeting.service.EmployeeService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.mockito.Mockito;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@WebMvcTest(EmployeeController.class)
//public class EmployeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void createEmployee_ValidInput_ReturnsCreated() throws Exception {
//        Employee employee = new Employee();
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//
//        when(employeeService.createEmployee(any(Employee.class))).thenReturn(employee);
//
//        mockMvc.perform(post("/api/employees")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(employee)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("Test Employee"))
//                .andExpect(jsonPath("$.email").value("test@example.com"));
//    }
//
//    @Test
//    void getEmployeeById_ExistingId_ReturnsOk() throws Exception {
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("Test Employee");
//        employee.setEmail("test@example.com");
//
//        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(employee));
//
//        mockMvc.perform(get("/api/employees/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Test Employee"))
//                .andExpect(jsonPath("$.email").value("test@example.com"));
//    }
//
//    @Test
//    void getEmployeeById_NonExistingId_ReturnsNotFound() throws Exception {
//        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.empty());
//
//        mockMvc.perform(get("/api/employees/1"))
//                .andExpect(status().isNotFound());
//    }
//
//    @TestConfiguration
//    static class EmployeeServiceTestContextConfiguration {
//        @Bean
//        public EmployeeService employeeService() {
//            return Mockito.mock(EmployeeService.class); // Provide a mock EmployeeService
//        }
//    }
//}