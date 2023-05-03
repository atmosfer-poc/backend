package com.atmosferpoc.shared.model.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DomainDto {
    @NotBlank
    private String domain;
}
