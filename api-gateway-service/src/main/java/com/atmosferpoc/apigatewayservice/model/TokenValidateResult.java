package com.atmosferpoc.apigatewayservice.model;

import com.atmosferpoc.shared.security.TokenType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenValidateResult {
    private Long userId;
}
