package com.calendar.calendar_meeting.controller;

import com.calendar.calendar_meeting.entity.TimeSlot;
import com.calendar.calendar_meeting.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/free-slots")
    public ResponseEntity<List<TimeSlot>> findFreeSlots(
            @RequestParam Long employeeId1,
            @RequestParam Long employeeId2,
            @RequestParam(defaultValue = "30") int durationMinutes) {
        List<TimeSlot> freeSlots = calendarService.findFreeSlots(employeeId1, employeeId2, durationMinutes);
        return new ResponseEntity<>(freeSlots, HttpStatus.OK);
    }


}