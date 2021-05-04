package com.cbrl.couchbase.demo.infra.common.error.handling.handler.impl;

import com.cbrl.couchbase.demo.domain.common.exception.BusinessException;
import com.cbrl.couchbase.demo.infra.common.error.handling.configuration.ErrorMessageLocator;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiError;
import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessExceptionHandler {

    private final ErrorMessageLocator errorMessageLocator;

    @ExceptionHandler(BusinessException.class)
    public ApiResponse handleBusinessException(BusinessException exception) {

        ApiError apiError = errorMessageLocator.error(exception.getErrorKey(), exception.getArgs());
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, apiError);
    }

}
