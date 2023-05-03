package com.atmosferpoc.shared.context;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

@Slf4j
@UtilityClass
public class RequestContextAccessor {
    public static void setItem(String key, Object value) {
        try {
            RequestContextHolder.currentRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_REQUEST);
        } catch (IllegalStateException ex) {
            log.error("[RequestContextAccessor] (setItem) -> request context currently unavailable.");
        }
    }

    public static Optional<Object> getItem(String key) {
        try {
            return Optional.ofNullable(RequestContextHolder.currentRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_REQUEST));
        } catch (IllegalStateException ex) {
            log.error("[RequestContextAccessor] (setItem) -> request context currently unavailable.");
            return Optional.empty();
        }
    }
}
