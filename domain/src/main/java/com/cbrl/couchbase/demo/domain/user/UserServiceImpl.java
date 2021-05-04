package com.cbrl.couchbase.demo.domain.user;

import com.cbrl.couchbase.demo.domain.common.exception.BusinessException;
import com.cbrl.couchbase.demo.domain.user.command.UserCreate;
import com.cbrl.couchbase.demo.domain.user.model.User;
import com.cbrl.couchbase.demo.domain.user.port.incoming.UserPort;
import com.cbrl.couchbase.demo.domain.user.port.outgoing.UserDataPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserPort {

    private final UserDataPort userDataPort;

    @Override
    public void create(UserCreate user) {
        Optional<User> retrievedUser = userDataPort.getUser(user.getEmail());
        retrievedUser.ifPresent(document -> {
            throw new BusinessException("user.exist", document);
        });

        userDataPort.create(user);
    }
}
