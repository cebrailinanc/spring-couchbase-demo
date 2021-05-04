package com.cbrl.couchbase.demo.domain.user.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    String id;
    String firstName;
    String lastName;
    String email;
    LocalDate birthDate;
}
