package com.exercises.Foro_HubH2.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private Long phone;
    private String password;
    private String role;

}
