package com.exercises.Foro_HubH2.application.usecase;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface IAnswerEntityInteractor {
    Answer createAnswer(Answer answer);

    void deleteAnswer(Answer answer);

    Answer updateAnswer(Answer answer);

    Answer findByAnswerId(Long id);

    PageResponse<Answer> findByPost(Pageable pageable, Post post);

    PageResponse<Answer> findByCreationDateInRange(Pageable pageable, LocalDateTime beginDate, LocalDateTime endDate);

    PageResponse<Answer> findByAuthor(Pageable pageable, User author);

    PageResponse<Answer> findByMarkedAsSolutionEqualsTrue(Pageable pageable);

    PageResponse<Answer> findAll(Pageable pageable);

}
