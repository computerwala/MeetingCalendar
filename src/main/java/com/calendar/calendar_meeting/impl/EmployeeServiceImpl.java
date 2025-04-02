package com.calendar.calendar_meeting.impl;

import com.calendar.calendar_meeting.entity.Calendar;
import com.calendar.calendar_meeting.entity.Employee;
import com.calendar.calendar_meeting.exception.CalendarException;
import com.calendar.calendar_meeting.repository.CalendarRepository;
import com.calendar.calendar_meeting.repository.EmployeeRepository;
import com.calendar.calendar_meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CalendarRepository calendarRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CalendarRepository calendarRepository) {
        this.employeeRepository = employeeRepository;
        this.calendarRepository = calendarRepository;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new CalendarException("Employee with email " + employee.getEmail() + " already exists");
        }

        // Create employee and initialize calendar
        Calendar calendar = new Calendar();
        calendar.setEmployee(employee);
        employee.setCalendar(calendar);

        employee = employeeRepository.save(employee);
        calendarRepository.save(calendar);

        return employee;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}