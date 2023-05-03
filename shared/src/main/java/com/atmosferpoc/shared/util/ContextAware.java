package com.atmosferpoc.shared.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ContextAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) {
        ContextAware.applicationContext = applicationContext;
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }


    public static <T> T getBean(Class<T> beanName) {
        return applicationContext.getBean(beanName);
    }
}