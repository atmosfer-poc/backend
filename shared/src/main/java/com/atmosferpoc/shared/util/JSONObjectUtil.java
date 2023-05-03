package com.atmosferpoc.shared.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JSONObjectUtil {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static String toString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            try {
                return object.toString();
            } catch (Exception ex) {
                return "";
            }
        }
    }

    public static <T> T toObject(String objStr, TypeReference<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(objStr, valueType);
    }

    public static <T> T toObject(String objStr, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(objStr, valueType);
    }
}
