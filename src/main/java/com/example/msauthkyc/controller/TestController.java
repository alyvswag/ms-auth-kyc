package com.example.msauthkyc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> me() {
        return ResponseEntity.ok("SALAM AUTH KECILDI");
    }
}