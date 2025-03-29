package com.exercises.Foro_HubH2.infrastructure.common.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class UserEntity {

    @Id
    private Long id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private Long phone;
    @NotBlank
    private String password;
    private String role = "user";
}
