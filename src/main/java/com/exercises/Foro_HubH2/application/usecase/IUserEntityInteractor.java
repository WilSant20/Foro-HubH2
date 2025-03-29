package com.exercises.Foro_HubH2.application.usecase;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.User;
import org.springframework.data.domain.Pageable;


public interface IUserEntityInteractor{
    User findById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    User findByEmail(String email);

    PageResponse<User> findAll(Pageable pageable);

    PageResponse<User> findByNameContainsIgnoreCase(Pageable pageable, String name);
}
