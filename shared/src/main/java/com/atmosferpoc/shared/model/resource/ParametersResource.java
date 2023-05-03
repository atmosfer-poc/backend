package com.atmosferpoc.shared.model.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ParametersResource {
    private String ssoRedirectUrl;
    private String yaaniMailUrl;
    private String yaaniMailAdminUrl;
    private String bipMeetUrl;
    private String bipMeetAdminUrl;
    private String lifeBoxUrl;
    private String lifeBoxAdminUrl;
    private String buyUrl;
    private String basicPackagePrice;
    private String premiumPackagePrice;
    private String ssoPasswordChangeUrl;
}
