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
import java.util.Optional;

@Slf4j
@Component
public class TransactionDurationPostFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders header = exchange.getRequest().getHeaders();

        Optional<String> transactionTime = getTransactionTime(header);

        transactionTime.ifPresent(s -> {
            var diffMs = System.currentTimeMillis() - Long.parseLong(transactionTime.get());

            exchange.getResponse().getHeaders().add(HeaderNameConstants.TRANSACTION_DURATION, String.valueOf(diffMs));
        });

        return chain.filter(exchange);
    }

    private Optional<String> getTransactionTime(HttpHeaders header){
        return Optional.ofNullable(Objects.requireNonNull(header.get(HeaderNameConstants.TRANSACTION_TIME)).iterator().next());
    }

    @Override
    public int getOrder() {
        return FilterOrderType.POST.getOrder();
    }
}
