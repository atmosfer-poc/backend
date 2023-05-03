package com.atmosferpoc.accountservice.service;

import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.Token;
import com.atmosferpoc.shared.model.dto.TokenDto;
import com.atmosferpoc.shared.model.resource.CurrentUserResource;
import com.atmosferpoc.shared.model.resource.TokenResource;

public interface TokenService extends BaseEntityService<Token, Long> {
    TokenResource createToken(TokenDto dto);

    CurrentUserResource getCurrentUser();

    void logout(Long userId);
}
