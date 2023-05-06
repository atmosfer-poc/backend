package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.shared.model.type.JobAdvertisementStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertisementResource extends BaseEntityResource {
    private Long id;
    private String title;
    private String content;
    private String image;
    private JobAdvertisementStatus status;
    private int applicationCount;
}
