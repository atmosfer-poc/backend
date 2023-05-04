package com.atmosferpoc.apigatewayservice.model.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpMethod;

@Getter
@Setter
@ToString
public class RequestParameters extends LogParameters {
    private String request;

    private String path;

    private String client;

    private HttpMethod httpMethod;

    private Long userId;
}
