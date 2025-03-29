package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.AnswerDto;

public class AnswerDtoMapper {
    public static AnswerDto AnswerToDto(Answer answer) {
        return new AnswerDto(answer.getAnswerId(), answer.getMessage(),
                answer.getPost() , answer.getCreationDate(), answer.getAuthor(),
                answer.getMarkedAsSolution());
    }
}
