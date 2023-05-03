package com.atmosferpoc.apigatewayservice.service.impl;

import com.atmosferpoc.apigatewayservice.model.GuardResult;
import com.atmosferpoc.apigatewayservice.repository.SecurityConfigurationRepository;
import com.atmosferpoc.apigatewayservice.secutiry.AuthenticationFactory;
import com.atmosferpoc.apigatewayservice.secutiry.AuthenticationType;
import com.atmosferpoc.apigatewayservice.service.SecurityService;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.entity.SecurityConfiguration;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.util.GFCUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityConfigurationRepository securityConfigurationRepository;
    private final AuthenticationFactory authenticationFactory;

    @Override
    public GuardResult checkGuard(ServerHttpRequest request) {
        Optional<SecurityConfiguration> configurationOpt = getEquivalentConfig(request);

        if (configurationOpt.isEmpty()) {
            return checkGuard(request, true, true, null);
        }

        var configuration = configurationOpt.get();

        if (!configuration.isRequireBasicAuthentication() && !configuration.isRequireBearerAuthentication()) {
            return GuardResult.permitAll();
        }

        return checkGuard(request, configuration.isRequireBasicAuthentication(), configuration.isRequireBearerAuthentication(), configuration.splitRequiredRoles());
    }

    private GuardResult checkGuard(ServerHttpRequest request, boolean requireBasicAuth, boolean requireBearerAuth, List<RoleType> requiredRoles) {
        Optional<User> authenticatedUser = Optional.empty();

        if (requireBearerAuth && authenticatedUser.isEmpty()) {
            authenticatedUser = authenticationFactory.getApplier(AuthenticationType.BEARER).apply(request);
        }

        if (authenticatedUser.isEmpty()) {
            return GuardResult.unauthorized();
        }

        var userRoleResult = getAuthenticatedUserRole(authenticatedUser.get());

        if(userRoleResult.isPresent()){
            boolean haveAccess = haveAccessAnyMatch(requiredRoles, userRoleResult.get());
            if(!haveAccess){
                return GuardResult.forbidden();
            }
        }

        return GuardResult
                .builder()
                .allowContinue(true)
                .authenticated(true)
                .user(authenticatedUser)
                .build();
    }

    private Optional<RoleType> getAuthenticatedUserRole(User user) {
        return Optional.of(user.getRole().getName());
    }

    private boolean haveAccessAnyMatch(List<RoleType> requiredRoles, RoleType userRole) {
        if (CollectionUtils.isEmpty(requiredRoles)) {
            return true;
        }

        return requiredRoles.contains(userRole);
    }

    private Optional<SecurityConfiguration> getEquivalentConfig(ServerHttpRequest request) {
        PathContainer microservicePath = request.getPath().subPath(3, 4);
        PathContainer nativePath = request.getPath().subPath(2, request.getPath().elements().size());

        List<SecurityConfiguration> configurations = securityConfigurationRepository.findByPath(microservicePath.value());

        if (configurations.isEmpty()) {
            return Optional.empty();
        }

        for (SecurityConfiguration c : configurations) {
            if (GFCUtil.strMatch(nativePath.value(), c.getMatcher())) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }
}
