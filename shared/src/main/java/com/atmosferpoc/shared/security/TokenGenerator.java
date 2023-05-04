package com.atmosferpoc.shared.security;

import com.atmosferpoc.shared.config.properties.SecurityConfigurationProperties;
import com.atmosferpoc.shared.model.resource.TokenResource;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class TokenGenerator {
    public final SecurityConfigurationProperties securityConfigurationProperties;

    public TokenResource generateToken(Claims settings) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", settings.getUserId());
        return doGenerateToken(claims, String.valueOf(settings.getUserId()));
    }

    private TokenResource doGenerateToken(Map<String, Object> claims, String subject) {
        var accessTokenExpirationDate = new Date(System.currentTimeMillis() + (long) securityConfigurationProperties.getAccessTokenMinutes() * 60 * 1000);
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(accessTokenExpirationDate)
                .signWith(SignatureAlgorithm.HS512, securityConfigurationProperties.getKey())
                .compact();

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (long) securityConfigurationProperties.getRefreshTokenMinutes() * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, securityConfigurationProperties.getKey())
                .compact();

        return TokenResource
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpirationDate(accessTokenExpirationDate)
                .scope(Collections.singletonList("ALL"))
                .type("Bearer")
                .build();
    }
}
