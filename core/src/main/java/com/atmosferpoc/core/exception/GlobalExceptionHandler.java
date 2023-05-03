package com.atmosferpoc.core.exception;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<?> customGeneralException(GeneralException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        errors.put("status", exception.getCode());
        errors.put("repeatable", exception.getRepeatable().toString());
        return new ResponseEntity<>(errors, exception.getHttpStatus());
    }

    @ExceptionHandler({JDBCConnectionException.class, DataAccessResourceFailureException.class})
    public ResponseEntity<?> jdbcConnectionException() {
        throw new GeneralException(ErrorStatusCode.DB_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        var fieldError = exception.getBindingResult().getFieldError();

        var errorMessage = "";

        if (Objects.nonNull(fieldError)) {
            errorMessage = fieldError.getField().concat(" ").concat(Objects.requireNonNullElse(fieldError.getDefaultMessage(), ""));
        } else {
            errorMessage = exception.getMessage();
        }
        Map<String, String> errors = new HashMap<>();
        errors.put("error", errorMessage);
        errors.put("status", String.valueOf(ErrorStatusCode.INVALID_FIELD.getValue()));
        errors.put("repeatable", Boolean.FALSE.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ErrorStatusCode.FILE_TOO_LARGE.getDescription());
        errors.put("status", String.valueOf(ErrorStatusCode.FILE_TOO_LARGE.getValue()));
        errors.put("repeatable", Boolean.FALSE.toString());
        return new ResponseEntity<>(errors, ErrorStatusCode.FILE_TOO_LARGE.getHttpStatus());
    }
}