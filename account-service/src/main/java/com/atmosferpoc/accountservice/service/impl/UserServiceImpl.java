package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.repository.UserRepository;
import com.atmosferpoc.accountservice.service.UserService;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl extends AbstractEntityService<User, Long> implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public Optional<User> findByEmail(String email) {
        return userRepository.findTopByEmail(email);
    }

    @Override
    public BaseJpaRepository<User, Long> getJpaRepository() {
        return userRepository;
    }
}
