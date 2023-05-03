package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUserResource {
    private Long userId;
    private String userName;
    private String userSurname;
    private String userFullname;
    private String shortName;
    private String mail;
    private String msisdn;
    private RoleType role;
}
