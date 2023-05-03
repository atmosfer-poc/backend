package com.atmosferpoc.shared.util;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class FileHelper {
    public static void checkExtension(MultipartFile file, List<String> acceptedExtensions) {
        String extension = getExtension(file.getOriginalFilename());
        var resultExtension= RemoveScriptUtil.removeScriptTags(extension);

        if (!acceptedExtensions.stream().map(String::toLowerCase).collect(Collectors.toList()).contains(extension)) {
            log.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, "[FileHelper]", "(checkExtension)", "", "Rejected file format is " + resultExtension));
            throw new GeneralException(ErrorStatusCode.FILE_EXTENSION_REJECTED);
        }
    }

    public static String getExtension(String fileName) {
        String[] parsedFileName = fileName.split("\\.");

        if (parsedFileName.length < 2) {
            return null;
        } else {
            return parsedFileName[parsedFileName.length - 1].toLowerCase(Locale.ROOT);
        }
    }

    public static void checkSize(MultipartFile file, long maxSize) {
        if (file.getSize() > maxSize) {
            log.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, "[FileHelper]", "(checkSize)", "", "Rejected file size is " + file.getSize()));
            throw new GeneralException(ErrorStatusCode.FILE_TOO_LARGE);
        }
    }
}
