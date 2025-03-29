package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository;

import com.exercises.Foro_HubH2.infrastructure.common.entity.TagEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMongoDbRepository extends MongoRepository<TagEntity, Long> {
}
