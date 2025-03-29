package com.exercises.Foro_HubH2.application.usecase.impl;

import com.exercises.Foro_HubH2.application.usecase.IUserEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.UserRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityInteractorImpl implements IUserEntityInteractor {

    private final UserRepositoryPort repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return repository.create(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.update(user);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public PageResponse<User> findAll(Pageable pageable) {
        return repository.findAll(pageable.getPageNumber(), pageable.getPageSize());
    }
    @Override
    public PageResponse<User> findByNameContainsIgnoreCase(Pageable pageable, String name) {
        return repository.findByNameContainsIgnoreCase(name, pageable.getPageNumber(), pageable.getPageSize());
    }
}
