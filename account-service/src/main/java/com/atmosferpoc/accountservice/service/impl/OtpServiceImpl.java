package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.repository.OtpRepository;
import com.atmosferpoc.accountservice.service.OtpService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.repository.BaseJpaRepository;
import com.atmosferpoc.core.service.AbstractEntityService;
import com.atmosferpoc.entity.Otp;
import com.atmosferpoc.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl extends AbstractEntityService<Otp, Long> implements OtpService {
    private final OtpRepository repository;

    @Override
    public void send(User user) {
        String otpValue = generateOtp();

        Otp otp = new Otp();
        otp.setUser(user);
        otp.setExpireTime(LocalDateTime.now().plus(150, ChronoUnit.SECONDS));
        otp.setValue(otpValue);

        save(otp);
    }

    @Override
    public void validate(User user, String otpValue) {
        Optional<Otp> otp = repository.findTopByUserIdAndValueOrderByCreatedDateDesc(user.getId(), otpValue);

        if (otp.isEmpty()) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Otp not found !");
        }

        /*if (otp.get().getExpireTime().isAfter(LocalDateTime.now())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Otp expire");
        }*/
    }

    private static String generateOtp() {
        return "123456";
    }

    @Override
    public BaseJpaRepository<Otp, Long> getJpaRepository() {
        return repository;
    }
}
