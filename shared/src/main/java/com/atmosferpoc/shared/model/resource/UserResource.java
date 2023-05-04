package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.model.type.UserStatusType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserResource extends BaseEntityResource {
    private String name;
    private String lastName;
    private String email;
    private String msisdn;
    private String password;
    private LocalDate dateOfBirth;
    private RoleType role;
}
