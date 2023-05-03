package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@UtilityClass
public class PhotoHelper {

    public static boolean hasPhotoFormat(MultipartFile photo) {
       return (Objects.requireNonNull(photo.getContentType()).startsWith("image/"));
    }
}