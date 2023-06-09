package com.atmosferpoc.shared.annotation;

import com.atmosferpoc.shared.config.feign.UserFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@FeignClient
public @interface AuthorizedUserFeignClient {

    @AliasFor(annotation = FeignClient.class, attribute = "name")
    String name() default "";

    /**
     * A custom <code>@Configuration</code> for the feign client.
     * <p>
     * Can contain override <code>@Bean</code> definition for the pieces that make up the client, for instance {@link
     * feign.codec.Decoder}, {@link feign.codec.Encoder}, {@link feign.Contract}.
     *
     */
    @AliasFor(annotation = FeignClient.class, attribute = "configuration")
    Class<?>[] configuration() default UserFeignClientConfiguration.class;

    /**
     * An absolute URL or resolvable hostname (the protocol is optional).
     */
    String url() default "";

    /**
     * Whether 404s should be decoded instead of throwing FeignExceptions.
     */
    boolean decode404() default false;

    /**
     * Fallback class for the specified Feign client interface. The fallback class must implement the interface
     * annotated by this annotation and be a valid Spring bean.
     */
    Class<?> fallback() default void.class;

    /**
     * Path prefix to be used by all method-level mappings. Can be used with or without <code>@RibbonClient</code>.
     */
    String path() default "";
}
