//package com.calendar.calendar_meeting.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.calendar.calendar_meeting.entity.Meeting;
//import com.calendar.calendar_meeting.repository.MeetingRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//@ExtendWith(MockitoExtension.class)
//class MeetingServiceTest {
//
//    @Mock
//    private MeetingRepository meetingRepository;
//
//    @InjectMocks
//    private MeetingServiceImpl meetingService;
//
//    private Meeting sampleMeeting;
//
//    @BeforeEach
//    void setUp() {
//        sampleMeeting = new Meeting();
//        sampleMeeting.setId(1L);
//        sampleMeeting.setTitle("Team Sync");
//    }
//
//    @Test
//    void testFindMeetingById_Success() {
//        when(meetingRepository.findById(1L)).thenReturn(Optional.of(sampleMeeting));
//
//        Meeting foundMeeting = meetingService.findMeetingById(1L);
//
//        assertNotNull(foundMeeting);
//        assertEquals(1L, foundMeeting.getId());
//        assertEquals("Team Sync", foundMeeting.getTitle());
//        verify(meetingRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void testFindMeetingById_NotFound() {
//        when(meetingRepository.findById(2L)).thenReturn(Optional.empty());
//
//        Meeting foundMeeting = meetingService.findMeetingById(2L);
//
//        assertNull(foundMeeting);
//        verify(meetingRepository, times(1)).findById(2L);
//    }
//
//    @Test
//    void testSaveMeeting() {
//        when(meetingRepository.save(any(Meeting.class))).thenReturn(sampleMeeting);
//
//        Meeting savedMeeting = meetingService.saveMeeting(sampleMeeting);
//
//        assertNotNull(savedMeeting);
//        assertEquals("Team Sync", savedMeeting.getTitle());
//        verify(meetingRepository, times(1)).save(sampleMeeting);
//    }
//}
