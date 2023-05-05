package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertisementResource extends BaseEntityResource {
    private Long id;
    private String title;
    private String content;
    private String image;
}
