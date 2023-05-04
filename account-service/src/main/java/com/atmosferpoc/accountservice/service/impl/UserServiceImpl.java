package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.repository.UserRepository;
import com.atmosferpoc.accountservice.service.ActivationTokenService;
import com.atmosferpoc.accountservice.service.UserService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.UserStatusType;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.User;
import com.atmosferpoc.entity.UserStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl extends AbstractEntityService<User, Long> implements UserService {
    private final UserRepository userRepository;
    private final ActivationTokenService activationTokenService;

    public UserServiceImpl(UserRepository userRepository,
                           ActivationTokenService activationTokenService) {
        this.userRepository = userRepository;
        this.activationTokenService = activationTokenService;
    }

    @Override
    protected User preSave(User entity) {
        if (userRepository.existsByEmail(entity.getEmail())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Email already exist.");
        }

        return super.preSave(entity);
    }

    @Override
    protected void postSave(User entity) {
        activationTokenService.sendActivationMail(entity);
    }

    @Override
    public Optional<User> find(String username, String password) {
        return userRepository.findTopByEmailAndPassword(username, password);
    }

    @Override
    public void checkDefaultUsers() {
        User user = User.defaultUser();

        Optional<User> byEmail = findByEmail(user.getEmail());

        if (byEmail.isEmpty()) {
            save(user);
        }
    }

    @Override
    public Optional<User> findActive(String username, String password) {
        return userRepository.findTopByEmailAndPasswordAndStatusName(username, password, UserStatusType.ACTIVE);
    }

    @Override
    public void activate(String token) {
        Long userId = activationTokenService.validate(token);

        User user = getEntity(userId);

        UserStatus activeStatus = new UserStatus();
        activeStatus.setName(UserStatusType.ACTIVE);
        activeStatus.setId(UserStatusType.ACTIVE.getId());
        user.setStatus(activeStatus);

        put(user.getId(), user);
    }

    @Override
    public void passwordReset(String email) {
        Optional<User> userOpt = userRepository.findTopByEmailAndStatusName(email, UserStatusType.ACTIVE);

        if (userOpt.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "User not found.");
        }

        activationTokenService.sendActivationMail(userOpt.get());
    }

    @Override
    public User checkPwdResetToken(String token) {
        Long userId = activationTokenService.validate(token);

        Optional<User> userOpt = userRepository.findTopByIdAndStatusName(userId, UserStatusType.ACTIVE);

        if (userOpt.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Invalid user.");
        }

        return userOpt.get();
    }

    @Override
    public void confirmPwdReset(String token, String password) {
        User user = checkPwdResetToken(token);

        user.setPassword(password);

        put(user.getId(), user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findTopByEmail(email);
    }

    @Override
    public BaseJpaRepository<User, Long> getJpaRepository() {
        return userRepository;
    }
}
