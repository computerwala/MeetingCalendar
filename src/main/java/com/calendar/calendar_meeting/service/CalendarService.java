package com.calendar.calendar_meeting.service;

import com.calendar.calendar_meeting.entity.TimeSlot;

import java.util.List;

public interface CalendarService {
    List<TimeSlot> findFreeSlots(Long employeeId1, Long employeeId2, int durationMinutes);
}
