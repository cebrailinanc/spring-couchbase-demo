package com.cbrl.couchbase.demo.infra.common.error.handling.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FieldError {
    private String field;
    private Object rejectedValue;
    private String message;
}
