package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.converter.UserConverter;
import com.atmosferpoc.accountservice.repository.TokenRepository;
import com.atmosferpoc.accountservice.service.OtpService;
import com.atmosferpoc.accountservice.service.TokenService;
import com.atmosferpoc.accountservice.service.UserService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.entity.Token;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.config.properties.SecurityConfigurationProperties;
import com.atmosferpoc.shared.model.dto.TokenDto;
import com.atmosferpoc.shared.model.resource.CurrentUserResource;
import com.atmosferpoc.shared.model.resource.TokenResource;
import com.atmosferpoc.shared.security.Claims;
import com.atmosferpoc.shared.security.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TokenServiceImpl extends AbstractEntityService<Token, Long> implements TokenService {
    private final TokenRepository tokenRepository;
    private final TokenGenerator tokenGenerator;
    private final UserService userService;
    private final OtpService otpService;

    public TokenServiceImpl(
            TokenRepository tokenRepository,
            UserService userService,
            SecurityConfigurationProperties securityConfigurationProperties,
            OtpService otpService
    ) {
        this.tokenRepository = tokenRepository;
        this.userService = userService;
        this.tokenGenerator = new TokenGenerator(securityConfigurationProperties);
        this.otpService = otpService;
    }

    @Override
    protected Token preSave(Token entity) {
        Optional<Token> activeToken = tokenRepository.getActiveToken(entity.getUserId());

        if (activeToken.isPresent()) {
            var token = activeToken.get();
            token.setEnable(false);
            put(token.getId(), token);
        }

        return super.preSave(entity);
    }

    @Override
    public TokenResource createToken(TokenDto dto) {
        Optional<User> user = findActiveUser(dto.getUsername(), dto.getPassword());

        if (user.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "User not found.");
        }

        checkMobilOrWebUser(user.get());

        if (StringUtils.isEmpty(dto.getOtp())) {
            otpService.send(user.get());
            return TokenResource.requireOtpResult();
        } else {
            otpService.validate(user.get(), dto.getOtp());
        }

        var tokenInfo = tokenGenerator.generateToken(Claims.builder()
                .userId(user.get().getId())
                .build());

        save(tokenInfo, user.get());

        return tokenInfo;
    }

    private void checkMobilOrWebUser(User user) {
        RoleType userRole = user.getRole().getName();
        if (SecurityUtil.sourceIsMobil()) {
            if (!Arrays.asList(RoleType.APPLIER).contains(userRole)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "User can not login this role");
            }
        } else {
            if (!Arrays.asList(RoleType.ADMIN, RoleType.HR, RoleType.TECHNICAL, RoleType.FINANCE, RoleType.UNASSIGNED).contains(userRole)) {
                throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "User can not login this role");
            }
        }
    }

    @Override
    public CurrentUserResource getCurrentUser() {
        var userId = SecurityUtil.getLoggedUserId();

        User user = userService.getEntity(userId);

        return UserConverter.toCurrentUserModel(user);
    }

    @Override
    public void logout(Long userId) {
        List<Token> tokens = tokenRepository.getAllByEnableIsTrueAndUserId(userId);

        if (tokens.isEmpty()) {
            return;
        }

        tokens.forEach(token -> token.setEnable(false));

        putAll(tokens);
    }

    private Optional<User> findUser(String username, String password) {
        return userService.find(username, password);
    }

    private Optional<User> findActiveUser(String username, String password) {
        return userService.findActive(username, password);
    }

    private void save(TokenResource tokenInfo, User user) {
        var token = new Token();
        token.setAccessToken(tokenInfo.getAccessToken());
        token.setRefreshToken(tokenInfo.getRefreshToken());
        token.setUserId(user.getId());
        token.setAccessTokenExpirationDate(tokenInfo.getAccessTokenExpirationDate());

        save(token);
    }

    @Override
    public BaseJpaRepository<Token, Long> getJpaRepository() {
        return tokenRepository;
    }
}
