package com.calendar.calendar_meeting.dto;

import com.calendar.calendar_meeting.entity.TimeSlot;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class MeetingRequest {

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    private String description;

    @NotNull(message = "TimeSlot cannot be null")
    @Valid
    private TimeSlot timeSlot;

    @NotNull(message = "Organizer ID cannot be null")
    private Long organizerId;

    private Set<Long> participantIds;
}