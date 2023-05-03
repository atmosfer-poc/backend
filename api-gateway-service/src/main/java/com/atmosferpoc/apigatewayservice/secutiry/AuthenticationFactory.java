package com.atmosferpoc.apigatewayservice.secutiry;

import com.atmosferpoc.apigatewayservice.repository.TokenRepository;
import com.atmosferpoc.apigatewayservice.repository.UserRepository;
import com.atmosferpoc.apigatewayservice.secutiry.impl.BearerAuthenticationApplier;
import com.atmosferpoc.shared.config.properties.SecurityConfigurationProperties;
import com.atmosferpoc.shared.security.TokenValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationFactory {
    private final UserRepository userRepository;
    private final TokenValidator tokenValidator;
    private final TokenRepository tokenRepository;

    public AuthenticationFactory(
            UserRepository userRepository,
            SecurityConfigurationProperties securityConfigurationProperties,
            TokenRepository tokenRepository
    ) {
        this.userRepository = userRepository;
        this.tokenValidator = new TokenValidator(securityConfigurationProperties);
        this.tokenRepository = tokenRepository;
    }

    public AuthenticationApplier getApplier(AuthenticationType authenticationType) {
        if (authenticationType.equals(AuthenticationType.BEARER)) {
            return new BearerAuthenticationApplier(
                    userRepository,
                    tokenValidator,
                    tokenRepository
            );
        }

        throw new UnsupportedOperationException("Invalid authentication type");
    }
}
