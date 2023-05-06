package com.atmosferpoc.shared.model.resource;

import com.atmosferpoc.core.model.resource.BaseEntityResource;
import com.atmosferpoc.shared.model.type.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationResource extends BaseEntityResource {
    private Long id;
    private String name;
    private String surname;
    private String tckn;
    private String city;
    private String phoneNumber;
    private String workType;
    private ApplicationStatus status;
}
