package com.sms.controller;

import com.sms.model.SmsRequest;
import com.sms.service.SmsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sms")
@CrossOrigin(origins = "*")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/split")
    public ResponseEntity<List<String>> splitMessage(@Valid @RequestBody SmsRequest request) {
        List<String> parts = smsService.splitMessage(request.getMessage());
        return ResponseEntity.ok(parts);
    }
} 