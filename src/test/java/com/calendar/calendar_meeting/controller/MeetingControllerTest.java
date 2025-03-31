//package com.calendar.calendar_meeting.controller;
//
//import com.calendar.calendar_meeting.dto.MeetingRequest;
//import com.calendar.calendar_meeting.entity.Meeting;
//import com.calendar.calendar_meeting.entity.TimeSlot;
//import com.calendar.calendar_meeting.service.MeetingService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.mockito.Mockito;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(MeetingController.class)
//public class MeetingControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private MeetingService meetingService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void scheduleMeeting_ValidInput_ReturnsCreated() throws Exception {
//        MeetingRequest meetingRequest = new MeetingRequest();
//        meetingRequest.setTitle("Test Meeting");
//        meetingRequest.setOrganizerId(1L);
//        meetingRequest.setTimeSlot(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
//
//        Meeting meeting = new Meeting();
//        meeting.setTitle("Test Meeting");
//
//        when(meetingService.scheduleMeeting(any(MeetingRequest.class))).thenReturn(meeting);
//
//        mockMvc.perform(post("/api/meetings")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(meetingRequest)))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    void checkConflicts_ValidInput_ReturnsOk() throws Exception {
//        MeetingRequest meetingRequest = new MeetingRequest();
//        meetingRequest.setTitle("Test Meeting");
//        meetingRequest.setOrganizerId(1L);
//        meetingRequest.setTimeSlot(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
//
//        Map<Long, List<Meeting>> conflicts = new HashMap<>();
//        when(meetingService.findConflicts(any(MeetingRequest.class))).thenReturn(conflicts);
//
//        mockMvc.perform(post("/api/meetings/check-conflicts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(meetingRequest)))
//                .andExpect(status().isOk());
//    }
//
//    @TestConfiguration
//    static class MeetingServiceTestContextConfiguration {
//        @Bean
//        public MeetingService meetingService() {
//            return Mockito.mock(MeetingService.class); // Provide a mock MeetingService
//        }
//    }
//}