package com.atmosferpoc.accountservice.controller;


import com.atmosferpoc.shared.endpoints.AccountEndpoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoints.HEALTH)
public class HealthController {
    @GetMapping
    public ResponseEntity<Void> heartbeat(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
