package com.atmosferpoc.shared.model.resource;

import java.util.List;


import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.model.type.LovType;

import lombok.Data;

@Data
public class LovResource extends BaseEntityResource{
    private String displayName;
    private String term;
    private LovType type;
    private LovResource parent;
    private List<LovResource> children;
}
