package com.calendar.calendar_meeting.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ErrorMessage {
    private String message;
    private Integer statusCode;
    private LocalDateTime timeStamp;
}

