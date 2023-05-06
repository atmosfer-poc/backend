package com.atmosferpoc.core.controller;

import com.atmosferpoc.core.annotation.LogConsole;
import com.atmosferpoc.core.model.dto.BaseEntityDto;
import com.atmosferpoc.core.entity.BaseEntity;
import com.atmosferpoc.core.model.resource.BaseEntityResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class AbstractReadEntityController<D extends BaseEntityDto, E extends BaseEntity, R extends BaseEntityResource, P extends Serializable> extends AbstractBaseController<D, E, R, P> {
    protected AbstractReadEntityController() {
    }

    @LogConsole
    @GetMapping({"/all"})
    @Transactional
    public List<R> all(@RequestParam(value = "audit", defaultValue = "false") boolean isExistAudit) {
        List<E> all = this.getService().all();
        List<R> resources = this.toResource(all);
        if (!isExistAudit)
            clearAuditing(resources);
        return resources;
    }

    public List<R> all(boolean isExistAudit,
                       Specification<E> spec) {
        List<E> all = this.getService().all(spec);
        List<R> resources = this.toResource(all);
        if (!isExistAudit)
            clearAuditing(resources);
        return resources;
    }

    @LogConsole
    @GetMapping({"/pageable"})
    @Transactional
    public PageImpl<R> pageable(@RequestParam(value = "page", defaultValue = "0") int page,
                                @RequestParam(value = "size", defaultValue = "20") int size,
                                @RequestParam(name = "sort", required = false) String sort,
                                @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
                                @RequestParam(value = "audit", defaultValue = "false") boolean isExistAudit) {
        Pageable pageable = PageRequest.of(page, size);
        if (StringUtils.isNotBlank(sort)) {
            pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction), sort);
        }
        PageImpl<E> resultEntityPage = this.getService().pageable(pageable);
        return preparePageableResponse(resultEntityPage, pageable, isExistAudit);
    }

    @Transactional
    public PageImpl<R> pageable(int page,
                                int size,
                                String sort,
                                String direction,
                                boolean isExistAudit,
                                Specification<E> spec) {
        Pageable pageable = PageRequest.of(page, size);
        if (StringUtils.isNotBlank(sort)) {
            pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction), sort);
        }
        PageImpl<E> resultEntityPage = this.getService().pageable(pageable, spec);
        return preparePageableResponse(resultEntityPage, pageable, isExistAudit);
    }

    private PageImpl<R> preparePageableResponse(PageImpl<E> resultEntityPage, Pageable pageable, boolean isExistAudit) {
        List<E> resultEntities = resultEntityPage.getContent();
        List<R> resultResources = resultEntities.stream().map(this::toResource).toList();
        if (!isExistAudit)
            clearAuditing(resultResources);
        return new PageImpl<>(resultResources, pageable, resultEntityPage.getTotalElements());
    }

    @LogConsole
    @GetMapping({"/{id}"})
    @Transactional
    public R get(@PathVariable("id") P id,
                 @RequestParam(value = "audit", defaultValue = "false") boolean isExistAudit) {
        var resource = toResource(this.getService().getEntity(id));
        if (!isExistAudit) {
            clearAuditing(resource);
        }
        return resource;
    }
}
