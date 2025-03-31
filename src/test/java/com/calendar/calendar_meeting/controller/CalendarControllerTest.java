//package com.calendar.calendar_meeting.controller;
//
//import com.calendar.calendar_meeting.entity.TimeSlot;
//import com.calendar.calendar_meeting.service.CalendarService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.mockito.Mockito;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(CalendarController.class)
//public class CalendarControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private CalendarService calendarService;
//
//    @Test
//    void findFreeSlots_ValidInput_ReturnsOk() throws Exception {
//        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
//        when(calendarService.findFreeSlots(1L, 2L, 30)).thenReturn(List.of(timeSlot));
//
//        mockMvc.perform(get("/api/calendars/free-slots?employeeId1=1&employeeId2=2&durationMinutes=30"))
//                .andExpect(status().isOk());
//    }
//
//    @TestConfiguration
//    static class CalendarServiceTestContextConfiguration {
//        @Bean
//        public CalendarService calendarService() {
//            return Mockito.mock(CalendarService.class); // Provide a mock CalendarService
//        }
//    }
//}