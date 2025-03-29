package com.exercises.Foro_HubH2.domain.repository;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.User;

public interface UserRepositoryPort {
    User create(User user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    PageResponse<User> findByNameContainsIgnoreCase(String Name, int page, int size);

    User findByEmail(String email);

    PageResponse<User> findAll(int page, int size);
}
