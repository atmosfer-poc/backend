package com.atmosferpoc.shared.endpoints;

import com.atmosferpoc.shared.endpoints.base.BaseEndpoints;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductEndpoints extends BaseEndpoints {
    public static final String PRODUCT = BASE + "/products";
    public static final String PAGEABLE = PRODUCT + "/pageable";

}
