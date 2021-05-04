package com.cbrl.couchbase.demo.infra.common.error.handling.handler.impl;

import com.cbrl.couchbase.demo.infra.common.error.handling.handler.Handler;
import com.cbrl.couchbase.demo.infra.common.error.handling.configuration.ErrorMessageLocator;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiError;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RequiredArgsConstructor
@RestControllerAdvice
public class UnhandledExceptionHandler implements Handler<Exception> {

    private static final String ERROR_KEY = "unhandled.exception";

    private final ErrorMessageLocator errorMessageLocator;

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @Override
    public ApiResponse handleException(Exception exception) {
        log.error("unhandled exception: {}", exception);

        ApiError apiError = errorMessageLocator.error(ERROR_KEY);
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, apiError);
    }
}
