package com.calendar.calendar_meeting.repository;

import com.calendar.calendar_meeting.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Optional<Calendar> findByEmployeeId(Long employeeId);
}