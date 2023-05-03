package com.atmosferpoc.core.util;

import com.atmosferpoc.core.model.pojo.AuthenticationInfo;
import com.atmosferpoc.core.model.type.ChannelType;
import com.atmosferpoc.core.constant.HeaderNameConstants;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

@UtilityClass
public class SecurityUtil {
    public static AuthenticationInfo getAuthenticationInfo() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            return AuthenticationInfo.anonymous();
        }

        HttpServletRequest request = attributes.getRequest();

        String loggedUserIdStr = request.getHeader(HeaderNameConstants.AUTHENTICATED_USER_ID);
        String loggedAccountIdStr = request.getHeader(HeaderNameConstants.AUTHENTICATED_ACCOUNT_ID);
        String transactionId = request.getHeader(HeaderNameConstants.TRANSACTION_ID);
        String isAuthenticatedStr = request.getHeader(HeaderNameConstants.IS_AUTHENTICATED);
        String requestedChannelIdStr = request.getHeader(HeaderNameConstants.AUTHENTICATED_CHANNEL_ID);

        var authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setTransactionId(transactionId);
        if (StringUtils.isBlank(isAuthenticatedStr)) {
            authenticationInfo.setAuthenticated(false);
            authenticationInfo.setRequestedChannelId(Optional.empty());
            authenticationInfo.setLoggedUserId(Optional.empty());
            authenticationInfo.setLoggedAccountId(Optional.empty());
            return authenticationInfo;
        } else {
            authenticationInfo.setAuthenticated(Boolean.parseBoolean(isAuthenticatedStr));
        }

        if (StringUtils.isBlank(loggedUserIdStr) || loggedUserIdStr.equals("null")) {
            authenticationInfo.setLoggedUserId(Optional.empty());
        } else {
            authenticationInfo.setLoggedUserId(Optional.of(Long.parseLong(loggedUserIdStr)));
        }

        if (StringUtils.isBlank(loggedAccountIdStr) || loggedAccountIdStr.equals("null")) {
            authenticationInfo.setLoggedAccountId(Optional.empty());
        } else {
            authenticationInfo.setLoggedAccountId(Optional.of(Long.parseLong(loggedAccountIdStr)));
        }

        if (StringUtils.isBlank(requestedChannelIdStr)) {
            authenticationInfo.setRequestedChannelId(Optional.empty());
        } else {
            authenticationInfo.setRequestedChannelId(Optional.of(Long.parseLong(requestedChannelIdStr)));
        }

        return authenticationInfo;
    }

    public static ChannelType getChannel() {
        var authenticationInfo = getAuthenticationInfo();
        Long channelId = authenticationInfo.getRequestedChannelId().orElse(ChannelType.DBS.getId());
        return ChannelType.fromId(channelId);
    }

    public static String getTransactionId() {
        var authenticationInfo = getAuthenticationInfo();
        return authenticationInfo.getTransactionId();
    }

    public static Long getLoggedUserId() {
        var authenticationInfo = getAuthenticationInfo();
        Optional<Long> loggedUserId = authenticationInfo.getLoggedUserId();

        if (loggedUserId.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return loggedUserId.get();
    }

    public static Long getLoggerAccountId() {
        var authenticationInfo = getAuthenticationInfo();
        Optional<Long> loggedAccountId = authenticationInfo.getLoggedAccountId();

        if (loggedAccountId.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.REQUIRE_LOGGED_ACCOUNT_ID);
        }

        return loggedAccountId.get();
    }
}
