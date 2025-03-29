package com.exercises.Foro_HubH2.infrastructure.common.entity.dto;

import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;

import java.time.LocalDateTime;

public record AnswerDto(
        Long AnswerId,
        String message,
        Post post,
        LocalDateTime creationDate,
        User author,
        Boolean markedAsSolution
) {
}
