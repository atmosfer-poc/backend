package com.atmosferpoc.shared.model.dto;

import com.atmosferpoc.core.model.type.AuthenticationFactorType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthenticationFactorDto {
    @NotNull
    private AuthenticationFactorType authFactor;
}
