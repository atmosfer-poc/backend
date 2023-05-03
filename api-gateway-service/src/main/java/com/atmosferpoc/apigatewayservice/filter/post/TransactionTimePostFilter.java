package com.atmosferpoc.apigatewayservice.filter.post;

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

import java.util.Objects;

@Slf4j
@Component
public class TransactionTimePostFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders header = exchange.getRequest().getHeaders();

        exchange.getResponse().getHeaders().add(HeaderNameConstants.TRANSACTION_TIME, getTransactionTime(header));

        return chain.filter(exchange);
    }

    private String getTransactionTime(HttpHeaders header){
        return Objects.requireNonNull(header.get(HeaderNameConstants.TRANSACTION_TIME)).iterator().next();
    }

    @Override
    public int getOrder() {
        return FilterOrderType.POST.getOrder();
    }
}
