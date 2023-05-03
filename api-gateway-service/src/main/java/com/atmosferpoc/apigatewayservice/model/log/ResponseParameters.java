package com.atmosferpoc.apigatewayservice.model.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseParameters extends LogParameters {
    private Long duration;

    private String resultCode;

    private String response;
}
