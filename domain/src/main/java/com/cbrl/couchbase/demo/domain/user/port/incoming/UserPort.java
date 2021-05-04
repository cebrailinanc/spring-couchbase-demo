package com.cbrl.couchbase.demo.domain.user.port.incoming;

import com.cbrl.couchbase.demo.domain.user.command.UserCreate;

public interface UserPort {
    void create(UserCreate userCreate);
}
