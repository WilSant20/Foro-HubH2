package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.UserEntity;

public class UserEntityMapper {

    public static User fromEntityToUser(UserEntity user) {
        return new User(
                user.getId(), user.getName(),
                user.getEmail(), user.getPhone(),
                user.getPassword(), user.getRole());

    }

    public static UserEntity fromUserToEntity(User user) {
        return new UserEntity(
                user.getId(), user.getName(),
                user.getEmail(), user.getPhone(),
                user.getPassword(), user.getRole()
        );
    }
}
