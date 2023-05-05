package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AdvertisementEndpoints extends BaseEndpoints {
    public static final String ADVERTISEMENT = BASE + "/advertisements";
    public static final String ADVERTISEMENT_SUMMARY_OPEN = "/summary/open";
    public static final String ADVERTISEMENT_APPLY = "{id}/apply";
}
