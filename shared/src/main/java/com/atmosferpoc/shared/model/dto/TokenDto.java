package com.atmosferpoc.shared.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
