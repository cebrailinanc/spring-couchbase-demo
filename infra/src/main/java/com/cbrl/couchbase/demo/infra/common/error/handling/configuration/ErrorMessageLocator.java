package com.cbrl.couchbase.demo.infra.common.error.handling.configuration;

import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
public class ErrorMessageLocator {
    private static final String SEPARATOR = ";";

    private final ResourceBundleMessageSource messageSource;

    public ApiError error(String key, Object... args) {
        String[] split = messageSource.getMessage(key, args, Locale.ENGLISH).split(SEPARATOR);
        return ApiError.builder()
                .code(split[0])
                .message(split[1])
                .build();
    }
}
