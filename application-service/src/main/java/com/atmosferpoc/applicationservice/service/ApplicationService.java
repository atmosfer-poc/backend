package com.atmosferpoc.applicationservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.JobAdvertisementApplication;
import com.atmosferpoc.shared.model.dto.CommentDto;
import com.atmosferpoc.shared.model.resource.ResourceDTO;
import com.atmosferpoc.shared.model.type.ApplicationAction;

public interface ApplicationService extends BaseEntityService<JobAdvertisementApplication, Long> {
    ResourceDTO getCV(Long id);

    void action(Long id, ApplicationAction action, CommentDto commentDto);
}
