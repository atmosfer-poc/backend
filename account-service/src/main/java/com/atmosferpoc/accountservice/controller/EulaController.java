package com.atmosferpoc.accountservice.controller;

import com.atmosferpoc.accountservice.service.EulaService;
import com.atmosferpoc.shared.endpoints.AccountEndpoints;
import com.atmosferpoc.shared.model.resource.EulaResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoints.EULA)
@RequiredArgsConstructor
public class EulaController {
    private final EulaService eulaService;

    @GetMapping
    public EulaResource getEula() {
        return eulaService.get();
    }
}
