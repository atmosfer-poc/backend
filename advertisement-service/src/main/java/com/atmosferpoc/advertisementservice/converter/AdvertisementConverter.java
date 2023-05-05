package com.atmosferpoc.advertisementservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.entity.JobAdvertisements;
import com.atmosferpoc.shared.model.dto.AdvertisementDto;
import com.atmosferpoc.shared.model.resource.AdvertisementResource;
import com.atmosferpoc.shared.util.IOHelper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementConverter implements BaseConverter<AdvertisementDto, JobAdvertisements, AdvertisementResource> {
    @SneakyThrows
    @Override
    public AdvertisementResource toResource(JobAdvertisements entity) {
        AdvertisementResource resource = new AdvertisementResource();

        resource.setContent(entity.getContent());
        resource.setId(entity.getId());
        resource.setTitle(entity.getTitle());
        resource.setImage(IOHelper.readAsBase64(entity.getImage()));

        return resource;
    }

    @Override
    public JobAdvertisements toEntity(AdvertisementDto dto) {
        JobAdvertisements entity = new JobAdvertisements();

        String fileName = "advertisement-".concat(dto.getTitle().replace(" ", "-"));

        String fileFullPath = IOHelper.save(dto.getImage(), dto.getFilePath(), fileName);

        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        entity.setImage(fileFullPath);

        return entity;
    }
}
