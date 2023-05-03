package com.atmosferpoc.shared.model.type;

import lombok.Getter;

@Getter
public enum UserSortFieldType {
    MSISDN("msisdn"),
    PACKAGE_TYPE("userPackage.pkg.name");

    private final String propertyPath;

    UserSortFieldType(String propertyPath) {
        this.propertyPath = propertyPath;
    }
}
