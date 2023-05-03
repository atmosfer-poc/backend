package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.model.type.UserStatusType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserItemResource extends BaseEntityResource {
    private Long id;
    private String companyName;
    private String name;
    private String lastName;
    private String mail;
    private String msisdn;
    private String hostName;
    private String freeTextAddress;
    private Long cityId;
    private Long districtId;
    private UserStatusType status;
    private String domain;
    private List<String> platforms = new ArrayList<>();
    private Long packageId;
    private Long subscriptionId;
    private String packageName;
    private Long authenticationMethodId;
    private RoleType role;
    private String authenticationFactor;
    private List<PlatformStateResource> platformStates;
    private String title;
    private String profilePhotoBase64;
}
