package com.atmosferpoc.core.model.type;

public enum LovType {
    CITY("city"),
    TOWN("town"),
    TRANSLATION_TR("tr"),
    TRANSLATION_EN("en"),
    TRANSLATION("translation");

    private final String value;

    LovType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
