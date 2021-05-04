package com.cbrl.couchbase.demo.domain.user.port.outgoing;

import com.cbrl.couchbase.demo.domain.user.command.UserCreate;
import com.cbrl.couchbase.demo.domain.user.model.User;

import java.util.Optional;

public interface UserDataPort {
    void create(UserCreate userCreate);

    Optional<User> getUser(String email);

}
