package com.atmosferpoc.accountservice.controller;

import com.atmosferpoc.accountservice.converter.UserConverter;
import com.atmosferpoc.accountservice.service.UserService;
import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.endpoints.AccountEndpoints;
import com.atmosferpoc.shared.model.dto.UserDto;
import com.atmosferpoc.shared.model.resource.UserResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoints.USERS)
public class UserController extends AbstractEntityController<UserDto, User, UserResource, Long> {
    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(
            UserService userService,
            UserConverter userConverter
    ) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    protected BaseEntityService<User, Long> getService() {
        return userService;
    }

    @Override
    protected BaseConverter<UserDto, User, UserResource> getConverter() {
        return userConverter;
    }
}
