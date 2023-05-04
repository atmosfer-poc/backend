package com.atmosferpoc.apigatewayservice.filter.post;

import com.atmosferpoc.apigatewayservice.secutiry.AuthenticationApplier;
import com.atmosferpoc.apigatewayservice.type.FilterOrderType;
import com.atmosferpoc.core.constant.HeaderNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Objects;

@Slf4j
@Component
public class TransactionIdPostFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders header = exchange.getRequest().getHeaders();

        exchange.getResponse().getHeaders().add(HeaderNameConstants.TRANSACTION_ID, getTransactionId(header));
        exchange.getResponse().getHeaders().add(AuthenticationApplier.AUTHORIZATION_HEADER, getHeader(header, AuthenticationApplier.AUTHORIZATION_HEADER));

        return chain.filter(exchange);
    }

    private String getHeader(HttpHeaders header, String key) {
        return Objects.requireNonNullElse(header.get(key), Collections.singletonList("")).iterator().next();
    }

    private String getTransactionId(HttpHeaders header){
        return Objects.requireNonNull(header.get(HeaderNameConstants.TRANSACTION_ID)).iterator().next();
    }

    @Override
    public int getOrder() {
        return FilterOrderType.POST.getOrder();
    }
}
