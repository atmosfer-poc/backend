package com.atmosferpoc.advertisementservice.converter;

import com.atmosferpoc.entity.JobAdvertisementApplication;
import com.atmosferpoc.shared.model.resource.ApplicationResource;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class AdvertisementApplicationConverter {
    public ApplicationResource toResource(JobAdvertisementApplication entity) {
        ApplicationResource resource = new ApplicationResource();

        resource.setId(entity.getId());
        resource.setName(entity.getName());
        resource.setSurname(entity.getSurname());
        resource.setTckn(entity.getTckn());
        resource.setCity(entity.getCity());
        resource.setPhoneNumber(entity.getPhoneNumber());
        resource.setWorkType(entity.getWorkType());
        resource.setStatus(entity.getStatus());

        return resource;
    }
}
