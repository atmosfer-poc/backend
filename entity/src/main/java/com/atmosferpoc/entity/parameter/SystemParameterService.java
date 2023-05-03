package com.atmosferpoc.entity.parameter;

import com.atmosferpoc.core.model.type.SystemParameterKeyType;

public interface SystemParameterService {
    String getParameterValue(SystemParameterKeyType key);

    void updateParameter(SystemParameterKeyType key, String value);
}
