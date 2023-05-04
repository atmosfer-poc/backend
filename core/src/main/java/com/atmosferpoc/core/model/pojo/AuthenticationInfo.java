package com.atmosferpoc.core.model.pojo;

import com.atmosferpoc.core.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class AuthenticationInfo {
    private boolean isAuthenticated;
    private boolean isMobil;
    private String transactionId;
    private Optional<Long> loggedUserId;
    private RoleType userRole;

    public static AuthenticationInfo anonymous() {
        var authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setAuthenticated(false);
        authenticationInfo.setLoggedUserId(Optional.empty());
        return authenticationInfo;
    }
}
