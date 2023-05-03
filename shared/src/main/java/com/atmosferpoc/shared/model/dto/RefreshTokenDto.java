package com.atmosferpoc.shared.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RefreshTokenDto {
    @JsonProperty("accessToken")
    @NotBlank
    private String tkn;
}
