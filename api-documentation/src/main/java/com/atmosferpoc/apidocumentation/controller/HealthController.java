package com.atmosferpoc.apidocumentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HealthController.HEALTH)
public class HealthController {
    public static final String HEALTH = "api/docs/health";

    @GetMapping
    public ResponseEntity<Void> heartbeat(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
