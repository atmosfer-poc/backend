package com.atmosferpoc.core.util;

import com.atmosferpoc.core.constant.HeaderNameConstants;
import com.atmosferpoc.core.model.pojo.AuthenticationInfo;
import com.atmosferpoc.core.model.type.RoleType;
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
        String transactionId = request.getHeader(HeaderNameConstants.TRANSACTION_ID);
        String isAuthenticatedStr = request.getHeader(HeaderNameConstants.IS_AUTHENTICATED);
        String requestedUserRoleStr = request.getHeader(HeaderNameConstants.AUTHENTICATED_USER_ROLE);

        var authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setTransactionId(transactionId);
        if (StringUtils.isBlank(isAuthenticatedStr)) {
            authenticationInfo.setAuthenticated(false);
            authenticationInfo.setLoggedUserId(Optional.empty());
            return authenticationInfo;
        } else {
            authenticationInfo.setAuthenticated(Boolean.parseBoolean(isAuthenticatedStr));
        }

        if (StringUtils.isBlank(loggedUserIdStr) || loggedUserIdStr.equals("null")) {
            authenticationInfo.setLoggedUserId(Optional.empty());
        } else {
            authenticationInfo.setLoggedUserId(Optional.of(Long.parseLong(loggedUserIdStr)));
        }

        authenticationInfo.setUserRole(RoleType.valueOf(requestedUserRoleStr));
        return authenticationInfo;
    }

    public static RoleType getRole() {
        AuthenticationInfo authenticationInfo = getAuthenticationInfo();

        return authenticationInfo.getUserRole();
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

    public static boolean sourceIsMobil() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String isMobilStr = request.getHeader(HeaderNameConstants.IS_MOBIL);
        return Boolean.parseBoolean(isMobilStr);
    }
}
