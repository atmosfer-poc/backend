package com.atmosferpoc.apigatewayservice.service;

import com.atmosferpoc.apigatewayservice.model.log.RequestParameters;
import com.atmosferpoc.apigatewayservice.model.log.ResponseParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;

public interface LogService {
    void log(LogType type, RequestParameters requestParameters, ResponseParameters responseParameters);
}
