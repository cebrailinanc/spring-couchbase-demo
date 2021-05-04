package com.cbrl.couchbase.demo.infra.common.error.handling.handler;

import com.cbrl.couchbase.demo.infra.common.error.handling.response.ApiResponse;

public interface Handler<T extends Exception> {
    ApiResponse handleException(T exception);
}
