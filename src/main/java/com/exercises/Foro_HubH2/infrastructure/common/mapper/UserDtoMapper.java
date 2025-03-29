package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.UserDto;

public class UserDtoMapper {
    public static UserDto UserToDto(User user) {
        return new UserDto
                (user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getPassword(), user.getRole());
    }
}
