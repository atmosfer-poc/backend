package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserResource extends BaseEntityResource {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String msisdn;
    private String password;
    private LocalDate dateOfBirth;
    private RoleType role;
}
