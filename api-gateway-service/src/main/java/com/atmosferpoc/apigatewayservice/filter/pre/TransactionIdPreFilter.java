package com.atmosferpoc.apigatewayservice.filter.pre;

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
public class TransactionIdPreFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        request = exchange.getRequest()
                .mutate()
                .header(HeaderNameConstants.TRANSACTION_ID, generateTransactionId())
                .header("Accept", "*")
                .build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    private String generateTransactionId() {
        return java.util.UUID.randomUUID().toString();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
