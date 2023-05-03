package com.atmosferpoc.shared.model.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LDAPSearchField {
    private String key;
    private String cn;
    private String sn;
    private String gn;
    private String mail;
    private String mobile;
    private String title;
}
