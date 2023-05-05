package com.atmosferpoc.advertisementservice.controller;

import com.atmosferpoc.advertisementservice.converter.AdvertisementConverter;
import com.atmosferpoc.advertisementservice.service.AdvertisementService;
import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.shared.endpoints.AdvertisementEndpoints;
import com.atmosferpoc.shared.model.dto.AdvertisementApplyDto;
import com.atmosferpoc.shared.model.dto.AdvertisementDto;
import com.atmosferpoc.shared.model.resource.AdvertisementResource;
import com.atmosferpoc.shared.model.resource.IdTitleResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(AdvertisementEndpoints.ADVERTISEMENT)
@RequiredArgsConstructor
public class AdvertisementController extends AbstractEntityController<AdvertisementDto, JobAdvertisements, AdvertisementResource, Long> {
    private final AdvertisementService service;
    private final AdvertisementConverter converter;

    @Value("${file.path}")
    private String filePath;

    @PostMapping
    @Override
    public AdvertisementResource save(AdvertisementDto dto) {
        if (!Objects.equals(RoleType.ADMIN, SecurityUtil.getRole())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unauthorize !");
        }

        dto.setFilePath(filePath);

        JobAdvertisements entity = getConverter().toEntity(dto);

        return toResource(getService().save(entity));
    }

    @GetMapping(AdvertisementEndpoints.ADVERTISEMENT_SUMMARY_OPEN)
    public List<IdTitleResource> getOpenSummaries() {
        return service.getOpenSummaries();
    }

    @PostMapping(AdvertisementEndpoints.ADVERTISEMENT_APPLY)
    public void applyAdvertisement(@PathVariable Long id, AdvertisementApplyDto dto) {
        service.apply(id, dto, filePath);
    }

    @Override
    protected BaseEntityService<JobAdvertisements, Long> getService() {
        return service;
    }

    @Override
    protected BaseConverter<AdvertisementDto, JobAdvertisements, AdvertisementResource> getConverter() {
        return converter;
    }
}
