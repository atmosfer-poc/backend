package com.atmosferpoc.apigatewayservice.model.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LogParameters {
    private String trxId;

    private String headers;
}
