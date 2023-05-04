package com.atmosferpoc.accountservice.controller;

import com.atmosferpoc.accountservice.converter.UserConverter;
import com.atmosferpoc.accountservice.service.UserService;
import com.atmosferpoc.core.controller.AbstractEntityController;
import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.service.BaseEntityService;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.shared.endpoints.AccountEndpoints;
import com.atmosferpoc.shared.model.dto.EmailDto;
import com.atmosferpoc.shared.model.dto.PasswordDto;
import com.atmosferpoc.shared.model.dto.UserDto;
import com.atmosferpoc.shared.model.resource.UserResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @PutMapping(AccountEndpoints.USER_ACTIVATE)
    public void activate(@PathVariable String token) {
        userService.activate(token);
    }

    @PutMapping(AccountEndpoints.USER_PWD_RESET)
    public void passwordReset(@RequestBody @Valid EmailDto emailDto) {
        userService.passwordReset(emailDto.getEmail());
    }

    @GetMapping(AccountEndpoints.USER_PWD_RESET_CHECK_TOKEN)
    public void checkPwdResetToken(@PathVariable String token) {
        userService.checkPwdResetToken(token);
    }

    @PutMapping(AccountEndpoints.USER_PWD_RESET_CONFIRM)
    public void confirmPwdReset(@PathVariable String token, @RequestBody @Valid PasswordDto dto) {
        userService.confirmPwdReset(token, dto.getPassword());
    }

    @GetMapping("all")
    @Override
    public List<UserResource> all(boolean isExistAudit) {
        if (!Objects.equals(RoleType.ADMIN, SecurityUtil.getRole())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unauthorize !");
        }
        return super.all(isExistAudit).stream().filter(u -> !Objects.equals(u.getRole(), RoleType.APPLIER)).collect(Collectors.toList());
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
