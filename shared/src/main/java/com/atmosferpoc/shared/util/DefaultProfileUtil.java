package com.atmosferpoc.shared.util;

import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.experimental.UtilityClass;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class DefaultProfileUtil {
    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put(ApplicationConstants.SPRING_PROFILE_DEFAULT, ApplicationConstants.SPRING_PROFILE_DEVELOPMENT);
        app.setDefaultProperties(defProperties);
    }

    public static void addProfiles(SpringApplication app, String... profiles) {
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put(ApplicationConstants.SPRING_PROFILE_DEFAULT, String.join(",", profiles));
        app.setDefaultProperties(defProperties);
    }

    public static String[] getActiveProfiles(Environment env) {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length == 0) {
            return env.getDefaultProfiles();
        }
        return profiles;
    }
}
