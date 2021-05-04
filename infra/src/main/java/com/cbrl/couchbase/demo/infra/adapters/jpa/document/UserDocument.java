package com.cbrl.couchbase.demo.infra.adapters.jpa.document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Document
public class UserDocument {
    @Id
    @GeneratedValue(strategy =
            GenerationStrategy.USE_ATTRIBUTES)
    String id;
    @Field
    String firstName;
    @Field
    String lastName;
    @Field
    @IdAttribute
    String email;
    @Field
    LocalDate birthDate;
}
