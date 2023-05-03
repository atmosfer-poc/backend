package com.atmosferpoc.shared.aop;

import com.atmosferpoc.shared.annotation.log.ExcludeLog;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Component
@Aspect
public class LoggingAspect {
    private final Logger consoleLogger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.atmosferpoc.shared.annotation.log.LogDatabase) ")
    public void logDatabasePointcut() {
    }

    @Pointcut("@annotation(com.atmosferpoc.shared.annotation.log.LogConsole)")
    public void logConsolePointcut() {
    }

    @Pointcut("@annotation(com.atmosferpoc.core.annotation.LogConsole)")
    public void logConsole2Pointcut() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void springControllerPointcut() {
    }

    @Around("springControllerPointcut()")
    public Object logAroundForControllerSpringBean(ProceedingJoinPoint joinPoint) throws Throwable {
        return logAroundInternal(joinPoint, true);
    }

    @Around("logDatabasePointcut()")
    public Object logAroundForLogDatabase(ProceedingJoinPoint joinPoint) throws Throwable {
        return logAroundInternal(joinPoint, true);
    }

    @Around("@annotation(com.atmosferpoc.shared.annotation.log.LogConsole)")
    public Object logAroundForLogConsole(ProceedingJoinPoint joinPoint) throws Throwable {
        return logAroundInternal(joinPoint, false);
    }

    @Around("@annotation(com.atmosferpoc.core.annotation.LogConsole)")
    public Object logAroundForLogConsole2(ProceedingJoinPoint joinPoint) throws Throwable {
        return logAroundInternal(joinPoint, false);
    }

    @AfterThrowing(pointcut = "springControllerPointcut()", throwing = "e")
    public void logAfterThrowingForSpringBean(JoinPoint joinPoint, Throwable e) {
        logAfterThrowingInternal(joinPoint, e, true);
    }

    @AfterThrowing(pointcut = "logDatabasePointcut()", throwing = "e")
    public void logAfterThrowingForDatabase(JoinPoint joinPoint, Throwable e) {
        logAfterThrowingInternal(joinPoint, e, true);
    }

    @AfterThrowing(pointcut = "logConsolePointcut()", throwing = "e")
    public void logAfterThrowingForConsole(JoinPoint joinPoint, Throwable e) {
        logAfterThrowingInternal(joinPoint, e, false);
    }

    private Object logAroundInternal(ProceedingJoinPoint joinPoint, Boolean isSendLogService) throws Throwable {
        Object result = null;
        var thisMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (Objects.nonNull(thisMethod.getAnnotation(ExcludeLog.class))) {
            result = joinPoint.proceed();
        } else {
            String className = ((MethodInvocationProceedingJoinPoint) joinPoint).getSourceLocation().getWithinType().getSimpleName();
            String methodName = thisMethod.getName();

            long startTime = System.currentTimeMillis();
            consoleLogger.info(String.format(ApplicationConstants.GENERAL_LOG_PATTERN, className, methodName, "input : ".concat(Arrays.toString(joinPoint.getArgs()))));

            result = joinPoint.proceed();

            long endTime = System.currentTimeMillis();
            long processTime = endTime - startTime;

            var message = "Duration : ".concat(String.valueOf(processTime)).concat("- Input : ").concat(Arrays.toString(joinPoint.getArgs()).concat("- Output : ").concat(Objects.requireNonNullElse(result, "").toString()));
            consoleLogger.info(String.format(ApplicationConstants.GENERAL_LOG_PATTERN, className, methodName, message));
        }
        return result;
    }

    public void logAfterThrowingInternal(JoinPoint joinPoint, Throwable e, Boolean isSendLogService) {
        Method thisMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (thisMethod.getAnnotation(ExcludeLog.class) == null) {
            String className = ((MethodInvocationProceedingJoinPoint) joinPoint).getSourceLocation().getWithinType().getName();
            String methodName = thisMethod.getName();

            consoleLogger.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, className, methodName, e.getMessage(), "Input : ".concat(Arrays.toString(joinPoint.getArgs()))));
        }
    }
}
