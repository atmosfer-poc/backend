package com.atmosferpoc.apigatewayservice.filter.post;

import com.atmosferpoc.apigatewayservice.model.log.ResponseParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import com.atmosferpoc.apigatewayservice.logger.RequestLogger;
import com.atmosferpoc.apigatewayservice.logger.ResponseLogger;
import com.atmosferpoc.apigatewayservice.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.PooledDataBuffer;
import org.springframework.data.util.Pair;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogPostFilter implements GlobalFilter, Ordered {
    private final LogService logService;
    private static Map<String, RequestLogger> requestLoggerMap = new HashMap<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var requestMutated = new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public Flux<DataBuffer> getBody() {
                var requestLogger = new RequestLogger(getDelegate());
                if (requestLogger.isWritableContentType(getHeaders().getContentType())) {
                    return super.getBody().map(ds -> {
                        requestLogger.appendBody(ds.asByteBuffer());
                        return ds;
                    }).doFinally(s -> requestLoggerMap.put(requestLogger.getTrxId(), requestLogger));
                } else {
                    requestLoggerMap.put(requestLogger.getTrxId(), requestLogger);
                    return super.getBody();
                }
            }
        };

        var responseMutated = new ServerHttpResponseDecorator(exchange.getResponse()) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                var responseLogger = new ResponseLogger(getDelegate());
                if (responseLogger.isWritableContentType(getHeaders().getContentType())) {
                    return join(body).flatMap(db -> {
                        responseLogger.appendBody(db.asByteBuffer());
                        saveLog(responseLogger);
                        return getDelegate().writeWith(Mono.just(db));
                    });
                } else {
                    saveLog(responseLogger);
                    return getDelegate().writeWith(body);
                }
            }
        };
        return chain.filter(exchange.mutate().request(requestMutated).response(responseMutated).build());
    }

    private Mono<? extends DataBuffer> join(Publisher<? extends DataBuffer> dataBuffers) {
        Assert.notNull(dataBuffers, "'dataBuffers' must not be null");
        return Flux.from(dataBuffers)
                .collectList()
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0).factory().join(list))
                .doOnDiscard(PooledDataBuffer.class, DataBufferUtils::release);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 2;
    }

    private void saveLog(ResponseLogger responseLogger) {
        var requestLogger = requestLoggerMap.get(responseLogger.getTrxId());
        Pair<LogType, ResponseParameters> logInfo = responseLogger.get();
        logService.log(logInfo.getFirst(), requestLogger.get().getSecond(), logInfo.getSecond());
        requestLoggerMap.remove(requestLogger.getTrxId());
    }
}
