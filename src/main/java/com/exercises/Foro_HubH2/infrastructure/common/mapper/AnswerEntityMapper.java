package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.infrastructure.common.entity.AnswerEntity;

public class AnswerEntityMapper {
    public static Answer fromEntityToAnswer(AnswerEntity answer) {
        return new Answer(answer.getAnswerId(), answer.getMessage(),
                PostEntityMapper.fromEntityToPost(answer.getPost()),
                answer.getCreationDate(),
                UserEntityMapper.fromEntityToUser(answer.getAuthor()), answer.getMarkedAsSolution());
    }

    public static AnswerEntity fromAnswerToEntity(Answer answer) {
        return new AnswerEntity(answer.getAnswerId(), answer.getMessage(),
                PostEntityMapper.fromPostToEntity(answer.getPost()), answer.getCreationDate(),
                UserEntityMapper.fromUserToEntity(answer.getAuthor()), answer.getMarkedAsSolution());
    }
}
