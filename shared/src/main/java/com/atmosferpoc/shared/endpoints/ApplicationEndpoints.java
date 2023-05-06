package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationEndpoints extends BaseEndpoints {
    public static final String APPLICATIONS = BASE + "/applications";
    public static final String CV =  "/{id}/cv";
    public static final String ACTION =  "/{id}/action/{action}";
}
