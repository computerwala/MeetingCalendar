package com.calendar.calendar_meeting.repository;

import com.calendar.calendar_meeting.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    // Find meetings by calendar ID
    List<Meeting> findByCalendarEmployeeId(Long employeeId);

    // Custom query to find overlapping meetings
    @Query("SELECT m FROM Meeting m WHERE m.calendar.employee.id = :employeeId " +
            "AND ((m.timeSlot.startTime <= :endTime AND m.timeSlot.endTime >= :startTime))")
    List<Meeting> findOverlappingMeetings(
            @Param("employeeId") Long employeeId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);
}
