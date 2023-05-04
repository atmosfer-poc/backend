package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.repository.ActivationTokenRepository;
import com.atmosferpoc.accountservice.service.ActivationTokenService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.ActivationToken;
import com.atmosferpoc.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivationTokenServiceImpl extends AbstractEntityService<ActivationToken, Long> implements ActivationTokenService {
    private final ActivationTokenRepository repository;

    @Override
    public BaseJpaRepository<ActivationToken, Long> getJpaRepository() {
        return repository;
    }

    @Override
    protected ActivationToken preSave(ActivationToken entity) {
        sendMail(entity.getUser().getEmail(), entity.getToken());

        return super.preSave(entity);
    }

    @Override
    public void sendActivationMail(User user) {
        String tokenVal = generateToken();

        ActivationToken activationToken = new ActivationToken();
        activationToken.setToken(tokenVal);
        log.info("Activation token : {}", tokenVal);
        activationToken.setExpireTime(LocalDateTime.now().plus(120, ChronoUnit.SECONDS));
        activationToken.setUser(user);

        save(activationToken);
    }

    @Override
    public Long validate(String token) {
        Optional<ActivationToken> tokenOpt = repository.findTopByTokenOrderByCreatedDateDesc(token);

        if (tokenOpt.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Token not found.");
        }

        /*if (tokenOpt.get().getExpireTime().isAfter(LocalDateTime.now())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Token expire");
        }*/

        return tokenOpt.get().getUser().getId();
    }

    private static String generateToken() {
        return UUID.randomUUID().toString();
    }

    private void sendMail(String mail, String token) {

    }
}
