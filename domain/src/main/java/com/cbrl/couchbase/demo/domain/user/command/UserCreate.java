package com.cbrl.couchbase.demo.domain.user.command;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
public class UserCreate {

    String firstName;
    String lastName;
    String email;
    LocalDate birthDate;
}
