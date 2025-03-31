package com.calendar.calendar_meeting.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Embeddable
public class TimeSlot {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeSlot() {}

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDurationInMinutes() {
        return (int) Duration.between(startTime, endTime).toMinutes();
    }
}