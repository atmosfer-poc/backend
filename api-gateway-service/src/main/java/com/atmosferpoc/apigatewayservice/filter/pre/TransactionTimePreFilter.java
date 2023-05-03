package com.atmosferpoc.apigatewayservice.filter.pre;

import com.atmosferpoc.core.constant.HeaderNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Slf4j
@Component
public class TransactionTimePreFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();

        if(hasTransactionTime(header)){
            log.info(format("Tracked request with transaction time %s", header.get(HeaderNameConstants.TRANSACTION_TIME)));
        }else{
            request = exchange.getRequest()
                    .mutate()
                    .header(HeaderNameConstants.TRANSACTION_TIME, String.valueOf(System.currentTimeMillis()))
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        }

        return chain.filter(exchange);
    }

    private boolean hasTransactionTime(HttpHeaders header){
        return header.containsKey(HeaderNameConstants.TRANSACTION_TIME);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
