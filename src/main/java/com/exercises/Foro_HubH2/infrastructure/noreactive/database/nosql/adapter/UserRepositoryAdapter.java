package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.adapter;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.UserRepositoryPort;
import com.exercises.Foro_HubH2.infrastructure.common.entity.UserEntity;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.UserEntityMapper;
import com.exercises.Foro_HubH2.infrastructure.exceptions.ResourceNotFoundException;
import com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository.UserMongodbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class  UserRepositoryAdapter implements UserRepositoryPort {
    private final UserMongodbRepository userMongodbRepository;
    @Override
    public User create(User user) {
        UserEntity userEntity = UserEntityMapper.fromUserToEntity(user);
        userMongodbRepository.save(userEntity);
        return UserEntityMapper.fromEntityToUser(userEntity);
    }

    @Override
    public User update(User user) {
        UserEntity userEntity =
                userMongodbRepository.findById(user.getId()).orElseThrow(() ->
                        new ResourceNotFoundException("User not found: "+user.getId()));
        Optional.ofNullable(user.getName())
                .ifPresent(userEntity::setName);
        Optional.ofNullable(user.getEmail())
                .ifPresent(userEntity::setEmail);
        Optional.ofNullable(user.getPhone())
                .ifPresent(userEntity::setPhone);
        Optional.ofNullable(user.getPassword())
                .ifPresent(userEntity::setPassword);
        return UserEntityMapper.fromEntityToUser(userMongodbRepository.save(userEntity));
    }

    @Override
    public void delete(User user) {
        UserEntity userEntity = UserEntityMapper.fromUserToEntity(user);
        userMongodbRepository.delete(userEntity);
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userMongodbRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "User entity not found, id: " + id));
        return UserEntityMapper.fromEntityToUser(userEntity);
    }

    @Override
    public PageResponse<User> findByNameContainsIgnoreCase(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> page1 = userMongodbRepository.findByNameContainsIgnoreCase(name, pageable);
        return new PageResponse<>(page1.getContent().stream().map(UserEntityMapper::fromEntityToUser).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public User findByEmail(String email) {
        return UserEntityMapper.fromEntityToUser(userMongodbRepository.findByEmail(email));
    }

    @Override
    public PageResponse<User> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> page1 = userMongodbRepository.findAll(pageable);
        return new PageResponse<>(page1.getContent().stream().map(UserEntityMapper::fromEntityToUser).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }
}
