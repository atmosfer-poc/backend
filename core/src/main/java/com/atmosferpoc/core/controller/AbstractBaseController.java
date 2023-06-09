package com.atmosferpoc.core.controller;

import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.core.service.BaseEntityService;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractBaseController<D extends BaseEntityDto, E extends BaseEntity, R extends BaseEntityResource, P extends Serializable> {
    protected AbstractBaseController() {
    }

    protected abstract BaseEntityService<E, P> getService();

    protected abstract BaseConverter<D, E, R> getConverter();

    protected List<R> toResource(List<E> all) {
        return !all.isEmpty() ? (List<R>) all.stream().map(e ->
                (BaseEntityResource) toResource(e)
        ).toList() : Collections.emptyList();
    }

    protected R toResource(E entity) {
        return entity != null ? this.getConverter().toResource(entity) : null;
    }

    protected R toResource(Optional<E> entity) {
        return entity.map(this::toResource).orElse(null);
    }

    protected List<E> toEntity(List<D> all) {
        return !all.isEmpty() ? all.stream().map(this::toEntity).toList() : null;
    }

    protected E toEntity(D dto) {
        return dto != null ? this.getConverter().toEntity(dto) : null;
    }

    protected E toEntity(Optional<D> dto) {
        return dto.map(this::toEntity).orElse(null);
    }


    protected void clearAuditing(R resource) {
    }

    protected void clearAuditing(List<R> resources) {
    }
}
