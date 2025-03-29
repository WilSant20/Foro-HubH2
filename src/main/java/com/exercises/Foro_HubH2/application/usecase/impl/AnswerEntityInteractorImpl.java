package com.exercises.Foro_HubH2.application.usecase.impl;

import com.exercises.Foro_HubH2.application.usecase.IAnswerEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Answer;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.AnswerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class AnswerEntityInteractorImpl implements IAnswerEntityInteractor {

    private AnswerRepositoryPort repository;

    @Override
    public Answer createAnswer(Answer answer) {
        return repository.create(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        repository.delete(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return repository.update(answer);
    }

    @Override
    public Answer findByAnswerId(Long id) {
        return repository.findByAnswerId(id);
    }

    @Override
    public PageResponse<Answer> findByPost(Pageable pageable, Post post) {
        return repository.findByPost(post, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Answer> findByCreationDateInRange(Pageable pageable, LocalDateTime beginDate, LocalDateTime endDate) {
        return repository.findByCreationDateInRange(beginDate, endDate, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Answer> findByAuthor(Pageable pageable, User author) {
        return repository.findByAuthor(author, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Answer> findByMarkedAsSolutionEqualsTrue(Pageable pageable) {
        return repository.findByMarkedAsSolutionEqualsTrue(pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Answer> findAll(Pageable pageable) {
        return repository.findAll(pageable.getPageNumber(), pageable.getPageSize());
    }
}
