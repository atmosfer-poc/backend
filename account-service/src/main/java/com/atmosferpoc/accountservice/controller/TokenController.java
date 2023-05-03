package com.atmosferpoc.accountservice.controller;

import com.atmosferpoc.accountservice.service.TokenService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.shared.endpoints.GatewayEndpoints;
import com.atmosferpoc.shared.model.dto.TokenDto;
import com.atmosferpoc.shared.model.resource.CurrentUserResource;
import com.atmosferpoc.shared.model.resource.TokenResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(GatewayEndpoints.TOKEN)
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @PostMapping
    public TokenResource createToken(@RequestBody @Valid TokenDto tokenDto) {
        return tokenService.createToken(tokenDto);
    }

    @GetMapping(GatewayEndpoints.CURRENT_USER)
    public CurrentUserResource currentUser() {
        return tokenService.getCurrentUser();
    }

    @GetMapping(GatewayEndpoints.LOGOUT)
    public void logout() {
        var authenticationInfo = SecurityUtil.getAuthenticationInfo();
        Long userId = authenticationInfo.getLoggedUserId().get();
        tokenService.logout(userId);
    }
}
