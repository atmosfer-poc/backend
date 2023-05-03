package com.atmosferpoc.core.model.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class AuthenticationInfo {
    private boolean isAuthenticated;
    private String transactionId;
    private Optional<Long> loggedUserId;
    private Optional<Long> loggedAccountId;
    private Optional<Long> requestedChannelId;

    public static AuthenticationInfo anonymous() {
        var authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setAuthenticated(false);
        authenticationInfo.setLoggedUserId(Optional.empty());
        authenticationInfo.setLoggedAccountId(Optional.empty());
        authenticationInfo.setRequestedChannelId(Optional.empty());
        return authenticationInfo;
    }
}
