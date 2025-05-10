package com.sms.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SmsService {
    private static final int MAX_SMS_LENGTH = 160;
    private static final String PART_SUFFIX = "... - Part %d of %d";

    public List<String> splitMessage(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        List<String> parts = new ArrayList<>();
        int totalParts = (int) Math.ceil((double) message.length() / (MAX_SMS_LENGTH - 20)); // 20 chars for suffix

        for (int i = 0; i < totalParts; i++) {
            int startIndex = i * (MAX_SMS_LENGTH - 20);
            int endIndex = Math.min(startIndex + (MAX_SMS_LENGTH - 20), message.length());
            
            String part = message.substring(startIndex, endIndex);
            String suffix = String.format(PART_SUFFIX, i + 1, totalParts);
            
            // Ensure the part with suffix doesn't exceed MAX_SMS_LENGTH
            while (part.length() + suffix.length() > MAX_SMS_LENGTH) {
                part = part.substring(0, part.length() - 1);
            }
            
            parts.add(part + suffix);
        }

        return parts;
    }
} 