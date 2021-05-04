package com.cbrl.couchbase.demo.infra.common.error.handling.handler.impl;

import com.cbrl.couchbase.demo.infra.common.error.handling.configuration.ErrorMessageLocator;
import com.cbrl.couchbase.demo.infra.common.error.handling.handler.Handler;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiError;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiResponse;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.FieldError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestControllerAdvice
public class MethodArgumentNotValidHandler implements Handler<MethodArgumentNotValidException> {
    private static final String ERROR_KEY = "validation.method-argument-not-valid";

    private final ErrorMessageLocator errorMessageLocator;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Override
    public ApiResponse handleException(MethodArgumentNotValidException exception) {
        ApiError apiError = errorMessageLocator.error(ERROR_KEY);

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> FieldError.builder()
                        .field(fieldError.getField())
                        .rejectedValue(fieldError.getRejectedValue())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        apiError.setFieldErrors(fieldErrors);
        return ApiResponse.error(HttpStatus.BAD_REQUEST, apiError);
    }
}
