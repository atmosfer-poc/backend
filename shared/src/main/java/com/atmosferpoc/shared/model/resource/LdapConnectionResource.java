package com.atmosferpoc.shared.model.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LdapConnectionResource {
    private String url;
    private String username;
    private boolean success;
}