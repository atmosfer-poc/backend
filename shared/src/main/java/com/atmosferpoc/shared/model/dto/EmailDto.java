package com.atmosferpoc.shared.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class EmailDto {
    @NotBlank
    private String email;
}
