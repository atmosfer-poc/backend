package com.atmosferpoc.advertisementservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.shared.model.dto.AdvertisementApplyDto;
import com.atmosferpoc.shared.model.resource.ApplicationResource;
import com.atmosferpoc.shared.model.resource.IdTitleResource;

import java.util.List;

public interface AdvertisementService extends BaseEntityService<JobAdvertisements, Long> {
    List<IdTitleResource> getOpenSummaries();

    void apply(Long advertisementId, AdvertisementApplyDto dto, String folderPath);

    List<ApplicationResource> getApplications(Long id);
}
