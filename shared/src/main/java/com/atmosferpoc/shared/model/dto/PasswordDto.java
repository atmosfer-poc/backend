package com.atmosferpoc.shared.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class PasswordDto {
    @NotBlank
    private String password;
}
