package com.atmosferpoc.shared.util;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FeignClientExceptionParser {
    public static String parseMessage(String methodKey, String exceptionMessage) {
        var parsedMessage = exceptionMessage.split(methodKey);

        if (parsedMessage.length > 1) {
            return parsedMessage[1].substring(3);
        }

        throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, exceptionMessage);
    }
}
