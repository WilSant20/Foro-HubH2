package com.exercises.Foro_HubH2.infrastructure.common.entity.dto;

import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


public record UserDto (
        Long id,
        String name,
        String email,
        Long phone,
        String password,
        String role
) {

}
