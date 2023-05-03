package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResource extends BaseEntityResource {
    private String name;
    private String lastName;
    private String email;
    private String msisdn;
    private String password;
}
