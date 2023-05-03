package com.atmosferpoc.core.converter;


import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.model.resource.BaseEntityResource;

public interface BaseConverter <D extends BaseEntityDto, E extends BaseEntity, R extends BaseEntityResource> {
    R toResource(E entity);

    E toEntity(D dto);
}
