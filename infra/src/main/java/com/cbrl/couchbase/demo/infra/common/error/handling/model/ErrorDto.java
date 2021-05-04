package com.cbrl.couchbase.demo.infra.common.error.handling.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {
    private String code;
    private String message;
}
