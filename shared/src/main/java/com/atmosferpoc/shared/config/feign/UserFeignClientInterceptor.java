package com.atmosferpoc.shared.config.feign;

import com.atmosferpoc.core.constant.HeaderNameConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class UserFeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (Objects.isNull(attributes)) {
            return;
        }

        HttpServletRequest currentRequest = attributes.getRequest();

        template.header(HeaderNameConstants.TRANSACTION_ID, currentRequest.getHeader(HeaderNameConstants.TRANSACTION_ID));
        template.header(HeaderNameConstants.TRANSACTION_TIME, currentRequest.getHeader(HeaderNameConstants.TRANSACTION_TIME));
        template.header(HeaderNameConstants.AUTHENTICATED_CHANNEL_ID, currentRequest.getHeader(HeaderNameConstants.AUTHENTICATED_CHANNEL_ID));
        template.header(HeaderNameConstants.AUTHENTICATED_USER_ID, currentRequest.getHeader(HeaderNameConstants.AUTHENTICATED_USER_ID));
        template.header(HeaderNameConstants.AUTHENTICATED_ACCOUNT_ID, currentRequest.getHeader(HeaderNameConstants.AUTHENTICATED_ACCOUNT_ID));
        template.header(HeaderNameConstants.IS_AUTHENTICATED, currentRequest.getHeader(HeaderNameConstants.IS_AUTHENTICATED));
    }
}
