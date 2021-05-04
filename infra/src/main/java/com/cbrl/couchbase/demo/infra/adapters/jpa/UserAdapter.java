package com.cbrl.couchbase.demo.infra.adapters.jpa;

import com.cbrl.couchbase.demo.domain.user.command.UserCreate;
import com.cbrl.couchbase.demo.domain.user.model.User;
import com.cbrl.couchbase.demo.domain.user.port.outgoing.UserDataPort;
import com.cbrl.couchbase.demo.infra.adapters.jpa.document.UserDocument;
import com.cbrl.couchbase.demo.infra.adapters.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAdapter implements UserDataPort {
    private final UserRepository userRepository;

    @Override
    public void create(UserCreate userCreate) {
        UserDocument document = new UserDocument();
        document.setFirstName(userCreate.getFirstName());
        document.setLastName(userCreate.getLastName());
        document.setEmail(userCreate.getEmail());
        document.setBirthDate(userCreate.getBirthDate());
        userRepository.save(document);

    }

    @Override
    public Optional<User> getUser(String email) {
        Optional<UserDocument> documents = userRepository.findById(email);

        return documents
                .map(document -> User.builder()
                        .id(document.getId())
                        .firstName(document.getFirstName())
                        .lastName(document.getLastName())
                        .email(document.getEmail())
                        .birthDate(document.getBirthDate())
                        .build());
    }
}
