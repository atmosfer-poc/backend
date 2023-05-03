package com.atmosferpoc.shared.model.dto;


import com.atmosferpoc.shared.model.type.DomainStatus;
import lombok.Data;

@Data
public class UpdateDomainStatus extends DomainDto {
    private DomainStatus domainStatus;
}
