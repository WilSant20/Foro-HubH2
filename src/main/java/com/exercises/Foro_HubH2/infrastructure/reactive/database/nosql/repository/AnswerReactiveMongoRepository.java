package com.exercises.Foro_HubH2.infrastructure.reactive.database.nosql.repository;

import com.exercises.Foro_HubH2.domain.models.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AnswerReactiveMongoRepository extends ReactiveMongoRepository<Answer, Long> {
}
