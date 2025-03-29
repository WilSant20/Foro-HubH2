package com.exercises.Foro_HubH2.domain.repository;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;

import java.time.LocalDateTime;

public interface AnswerRepositoryPort {
    Answer create(Answer answer);

    void delete(Answer answer);

    Answer update(Answer answer);

    Answer findByAnswerId(Long id);

    PageResponse<Answer> findByPost(Post post, int page, int size);

    PageResponse<Answer> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, int page, int size);

    PageResponse<Answer> findByAuthor(User author, int page, int size);

    PageResponse<Answer> findByMarkedAsSolutionEqualsTrue(int page, int size);

    PageResponse<Answer> findAll(int page, int size);
}
