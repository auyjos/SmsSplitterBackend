package com.sms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class SmsServiceTest {

    private SmsService smsService;

    @BeforeEach
    void setUp() {
        smsService = new SmsService();
    }

    @Test
    void splitMessage_ShortMessage_ReturnsSinglePart() {
        String message = "Hello, World!";
        List<String> parts = smsService.splitMessage(message);
        
        assertEquals(1, parts.size());
        assertTrue(parts.get(0).contains("Hello, World!"));
        assertTrue(parts.get(0).contains("Part 1 of 1"));
    }

    @Test
    void splitMessage_LongMessage_ReturnsMultipleParts() {
        StringBuilder longMessage = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            longMessage.append("a");
        }
        
        List<String> parts = smsService.splitMessage(longMessage.toString());
        
        assertTrue(parts.size() > 1);
        for (int i = 0; i < parts.size(); i++) {
            String part = parts.get(i);
            assertTrue(part.length() <= 160);
            assertTrue(part.contains(String.format("Part %d of %d", i + 1, parts.size())));
        }
    }

    @Test
    void splitMessage_NullMessage_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> smsService.splitMessage(null));
    }

    @Test
    void splitMessage_EmptyMessage_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> smsService.splitMessage(""));
    }
} 