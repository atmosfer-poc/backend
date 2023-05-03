package com.atmosferpoc.shared.model.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class TokenResource {
    private String accessToken;
    private String refreshToken;
    private Date accessTokenExpirationDate;
    private List<String> scope = new ArrayList<>();
    private String type;
    private boolean mustEula;
}
