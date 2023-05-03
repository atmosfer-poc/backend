package com.atmosferpoc.apigatewayservice.filter.pre;

import com.atmosferpoc.apigatewayservice.exception.ForbiddenException;
import com.atmosferpoc.apigatewayservice.exception.UnauthorizedException;
import com.atmosferpoc.apigatewayservice.model.GuardResult;
import com.atmosferpoc.apigatewayservice.service.SecurityService;
import com.atmosferpoc.core.constant.HeaderNameConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityPreFilter implements GlobalFilter, Ordered {
    private final SecurityService securityService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        var guardResult = securityService.checkGuard(request);

        willContinue(guardResult);

        if (guardResult.isAuthenticated()) {
            var user = guardResult.getUser().orElse(null);
            request = exchange.getRequest()
                    .mutate()
                    .header(HeaderNameConstants.AUTHENTICATED_USER_ID, String.valueOf(user.getId()))
                    .header(HeaderNameConstants.IS_AUTHENTICATED, Boolean.TRUE.toString())
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    private void willContinue(GuardResult guardResult){
        if (guardResult.isForbidden()) {
            throw new ForbiddenException();
        }
        if (!guardResult.isAllowContinue()) {
            throw new UnauthorizedException();
        }
    }
}
