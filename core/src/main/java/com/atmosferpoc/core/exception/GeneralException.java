package com.atmosferpoc.core.exception;

import com.atmosferpoc.core.util.SecurityUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralException extends RuntimeException {
    private final String message;
    private final String code;
    private final String transactionId;
    private final Boolean repeatable;
    private final HttpStatus httpStatus;

    public GeneralException(ErrorStatusCode err, String... params) {
        super();
        this.message = String.format(err.getDescription(), params);
        this.code = String.valueOf(err.getValue());
        this.repeatable = err.isRepeatable();
        this.transactionId = SecurityUtil.getTransactionId();
        this.httpStatus = err.getHttpStatus();
    }
}
