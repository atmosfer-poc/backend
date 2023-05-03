package com.atmosferpoc.shared.config.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class UserFeignClientConfiguration {

    @Bean(name = "userFeignClientInterceptor")
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new UserFeignClientInterceptor();
    }
}
