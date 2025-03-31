package com.calendar.calendar_meeting.service;

import com.calendar.calendar_meeting.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    Optional<Employee> getEmployeeByEmail(String email);
}