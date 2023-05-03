package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FileNameUtil {

    public static String getExtension(String fileName) {
        String[] parsedFileName = fileName.split("\\.");

        if (parsedFileName.length < 2) {
            return null;
        } else {
            return parsedFileName[parsedFileName.length - 1];
        }
    }
}
