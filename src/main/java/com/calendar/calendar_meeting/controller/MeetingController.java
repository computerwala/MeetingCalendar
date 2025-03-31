package com.calendar.calendar_meeting.controller;

import com.calendar.calendar_meeting.dto.MeetingRequest;
import com.calendar.calendar_meeting.entity.Meeting;
import com.calendar.calendar_meeting.service.MeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping
    public ResponseEntity<Meeting> scheduleMeeting(@Valid @RequestBody MeetingRequest meetingRequest) {
        Meeting scheduledMeeting = meetingService.scheduleMeeting(meetingRequest);
        return new ResponseEntity<>(scheduledMeeting, HttpStatus.CREATED);
    }

    @PostMapping("/check-conflicts")
    public ResponseEntity<Map<Long, List<Meeting>>> checkConflicts(@Valid @RequestBody MeetingRequest meetingRequest) {
        Map<Long, List<Meeting>> conflicts = meetingService.findConflicts(meetingRequest);
        return new ResponseEntity<>(conflicts, HttpStatus.OK);
    }

    // Additional meeting-related endpoints can be added here
}