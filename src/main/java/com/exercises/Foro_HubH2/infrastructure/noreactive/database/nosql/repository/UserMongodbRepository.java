package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository;

import com.exercises.Foro_HubH2.infrastructure.common.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongodbRepository extends MongoRepository<UserEntity, Long> {
    Page<UserEntity> findByNameContainsIgnoreCase(String name, Pageable pageable);

    UserEntity findByEmail(String email);

}
