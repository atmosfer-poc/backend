package com.atmosferpoc.shared.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Claims {
    private TokenType tokenType;
    private Long userId;
}
