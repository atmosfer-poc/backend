package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.type.AuthenticationMethodType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationMethodDetailItem {
    private Long id;
    private String url;
    private AuthenticationMethodType type;
    private String userName;
    @ToString.Exclude
    private String password;
    private String ldapSearchBase;
    private String ldapSearchQuery;
    @ToString.Exclude
    private String ldapPasswordAttribute;
    private String groupSearchBaseDN;
    private String groupSearchFilter;
    private String groupExclusionList;
    private String userLDAPGroupAttributes;
    private String status;
    private String ssoSearchQuery;
}
