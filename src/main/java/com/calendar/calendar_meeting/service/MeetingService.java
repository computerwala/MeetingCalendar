package com.calendar.calendar_meeting.service;

import com.calendar.calendar_meeting.dto.MeetingRequest;
import com.calendar.calendar_meeting.entity.Meeting;

import java.util.List;
import java.util.Map;

public interface MeetingService {
    Meeting scheduleMeeting(MeetingRequest meetingRequest);
    Map<Long, List<Meeting>> findConflicts(MeetingRequest meetingRequest);
}