package com.atmosferpoc.shared.aop;

import com.atmosferpoc.core.model.dto.IBaseDto;
import com.atmosferpoc.shared.annotation.ExcludeValidation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class RequestValidationAspect {
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void springControllerPointcut() {
    }

    @Before("springControllerPointcut()")
    public void requestValidationAspect(JoinPoint joinPoint) {
        var method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        if (Objects.nonNull(method.getAnnotation(ExcludeValidation.class))) {
            return;
        }

        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof IBaseDto) {
                ((IBaseDto) arg).validate();
            }
        }
    }
}
