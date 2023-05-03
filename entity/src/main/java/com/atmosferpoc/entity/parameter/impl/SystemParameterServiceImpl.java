package com.atmosferpoc.entity.parameter.impl;

import com.atmosferpoc.core.model.type.SystemParameterKeyType;
import com.atmosferpoc.entity.SystemParameters;
import com.atmosferpoc.entity.parameter.SystemParameterService;
import com.atmosferpoc.entity.parameter.repository.SystemParametersRepository;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import com.atmosferpoc.shared.model.pojo.ValuePojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemParameterServiceImpl implements SystemParameterService {
    private final SystemParametersRepository systemParametersRepository;

    @Override
    public String getParameterValue(SystemParameterKeyType key) {
        long startTime = System.currentTimeMillis();
        Optional<ValuePojo> valuePojo = systemParametersRepository.findValueByKey(key);

        String value = valuePojo.isEmpty() ? key.getDefaultValue() : valuePojo.get().getValue();

        log.info("[SystemParameterServiceImpl] (getParameterValue) {} value : {}", key, value);

        long endTime = System.currentTimeMillis();
        long processTime = endTime - startTime;
        log.info(String.format(ApplicationConstants.GENERAL_LOG_PATTERN, this.getClass().getSimpleName(), "getParameterValue", "duration : " + processTime));

        return value;
    }

    @Override
    public void updateParameter(SystemParameterKeyType key, String value) {
        Optional<SystemParameters> systemParameters = systemParametersRepository.findByKey(key);

        if (systemParameters.isEmpty()) {
            var newParameter = new SystemParameters();
            newParameter.setKey(key);
            newParameter.setValue(value);

            systemParametersRepository.save(newParameter);
            return;
        }

        var existParameter = systemParameters.get();
        existParameter.setValue(value);

        systemParametersRepository.save(existParameter);
    }
}
