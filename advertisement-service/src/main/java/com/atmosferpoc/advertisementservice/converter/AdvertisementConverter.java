package com.atmosferpoc.advertisementservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.shared.model.dto.AdvertisementDto;
import com.atmosferpoc.shared.model.resource.AdvertisementResource;
import com.atmosferpoc.shared.util.IOHelper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class AdvertisementConverter implements BaseConverter<AdvertisementDto, JobAdvertisements, AdvertisementResource> {
    @SneakyThrows
    @Override
    public AdvertisementResource toResource(JobAdvertisements entity) {
        AdvertisementResource resource = new AdvertisementResource();

        resource.setContent(entity.getContent());
        resource.setId(entity.getId());
        resource.setTitle(entity.getTitle());
        try {
            resource.setImage(IOHelper.readAsBase64(entity.getImage()));
        } catch (Exception ex) {
            log.warn("file not found");
        }
        resource.setStatus(entity.getStatus());
        resource.setApplicationCount(entity.getApplications().size());

        return resource;
    }

    @Override
    public JobAdvertisements toEntity(AdvertisementDto dto) {
        JobAdvertisements entity = new JobAdvertisements();

        if (Objects.nonNull(dto.getImage())) {
            String fileName = "advertisement-".concat(dto.getTitle().replace(" ", "-"));
            String fileFullPath = IOHelper.save(dto.getImage(), dto.getFilePath(), fileName);
            entity.setImage(fileFullPath);
        }

        entity.setStatus(dto.getStatus());
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());

        return entity;
    }
}
