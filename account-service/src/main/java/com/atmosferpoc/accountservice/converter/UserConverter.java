package com.atmosferpoc.accountservice.converter;

import com.atmosferpoc.core.converter.BaseConverter;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.model.type.UserStatusType;
import com.atmosferpoc.entity.Role;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.entity.UserStatus;
import com.atmosferpoc.shared.model.dto.UserDto;
import com.atmosferpoc.shared.model.resource.CurrentUserResource;
import com.atmosferpoc.shared.model.resource.UserResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
public class UserConverter implements BaseConverter<UserDto, User, UserResource> {

    public static CurrentUserResource toCurrentUserModel(User user) {
        CurrentUserResource currentUserResource = new CurrentUserResource();
        currentUserResource.setMsisdn(user.getMsisdn());
        currentUserResource.setRole(user.getRole().getName());
        currentUserResource.setUserId(user.getId());
        currentUserResource.setUserName(user.getName());
        currentUserResource.setUserSurname(user.getSurname());
        currentUserResource.setUserFullname(user.getName().concat(" ").concat(user.getSurname()));

        if (StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getSurname())) {
            currentUserResource.setShortName(String.valueOf(user.getName().charAt(0)).concat(String.valueOf(user.getSurname().charAt(0))).toUpperCase(Locale.ROOT));
        } else {
            currentUserResource.setShortName("-");
        }

        currentUserResource.setMail(user.getEmail());
        currentUserResource.setMsisdn(user.getMsisdn());

        return currentUserResource;
    }

    @Override
    public UserResource toResource(User entity) {
        UserResource user = new UserResource();
        user.setEmail(entity.getEmail());
        user.setMsisdn(entity.getMsisdn());
        user.setName(entity.getName());
        user.setLastName(entity.getSurname());

        return user;
    }

    @Override
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        UserStatus userStatus = new UserStatus();
        userStatus.setId(UserStatusType.ACTIVE.getId());
        userStatus.setName(UserStatusType.ACTIVE);

        user.setStatus(userStatus);

        Role role = new Role();
        role.setName(RoleType.USER);
        role.setId(RoleType.USER.getId());

        user.setRole(role);

        return user;
    }
}
