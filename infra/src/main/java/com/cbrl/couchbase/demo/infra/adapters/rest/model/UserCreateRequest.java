package com.cbrl.couchbase.demo.infra.adapters.rest.model;

import com.cbrl.couchbase.demo.domain.user.command.UserCreate;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Email
    String email;
    @NotNull
    LocalDate birthDate;

    public UserCreate toModel() {
        return UserCreate.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .birthDate(birthDate)
                .build();
    }
}
