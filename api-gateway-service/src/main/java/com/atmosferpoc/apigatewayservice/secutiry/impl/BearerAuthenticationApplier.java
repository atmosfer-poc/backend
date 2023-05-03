package com.atmosferpoc.apigatewayservice.secutiry.impl;

import com.atmosferpoc.apigatewayservice.model.TokenValidateResult;
import com.atmosferpoc.apigatewayservice.repository.TokenRepository;
import com.atmosferpoc.apigatewayservice.repository.UserRepository;
import com.atmosferpoc.apigatewayservice.secutiry.AuthenticationApplier;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import com.atmosferpoc.shared.security.TokenType;
import com.atmosferpoc.shared.security.TokenValidator;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class BearerAuthenticationApplier extends AuthenticationApplier {
    private final UserRepository userRepository;
    private final TokenValidator tokenValidator;
    private final TokenRepository tokenRepository;

    @Override
    public Optional<User> apply(ServerHttpRequest request) {
        Optional<TokenValidateResult> tokenValidateResult = validateToken(request);

        if (tokenValidateResult.isEmpty()) {
            return Optional.empty();
        }

        var tokenType = tokenValidateResult.get().getTokenType();
        Long userId = tokenValidateResult.get().getUserId();

        if (Objects.equals(tokenType, TokenType.PORTAL)) {
            return userRepository.findById(userId);
        } else {
            return Optional.empty();
        }
    }

    private Optional<TokenValidateResult> validateToken(ServerHttpRequest request) {
        Optional<String> tokenOtp = getToken(request);

        if (tokenOtp.isEmpty()) {
            return Optional.empty();
        }

        String token = tokenOtp.get();

        long userId;
        try {
            if (!tokenValidator.validateToken(token)) {
                log.info(String.format(ApplicationConstants.GENERAL_LOG_PATTERN, this.getClass().getSimpleName(), "validateToken", "Invalid token"));
                return Optional.empty();
            } else {
                userId = Long.parseLong(tokenValidator.getUsernameFromToken(token));
            }
        } catch (ExpiredJwtException ex ) {
            log.info(String.format(ApplicationConstants.GENERAL_LOG_PATTERN, this.getClass().getSimpleName(), "validateToken", "Invalid token"));
            return Optional.empty();
        } catch (Exception ex) {
            return Optional.empty();
        }

        if (!tokenRepository.existsByAccessTokenAndEnableIsTrue(token)) {
            return Optional.empty();
        }

        return Optional.of(TokenValidateResult
                .builder()
                .tokenType(TokenType.PORTAL)
                .userId(userId)
                .build()
        );
    }

    @Override
    public String getTokenPrefix() {
        return BEARER_AUTH_PREFIX;
    }
}
