package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository;

import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.AnswerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AnswerMongodbRepository extends MongoRepository<AnswerEntity, Long> {

    Page<AnswerEntity> findByPost(Long postId, Pageable pageable);

    @Query("{ 'creationDate' : { $gte: ?0, $lte: ?1 } }")
    Page<AnswerEntity> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, Pageable pageable);

    Page<AnswerEntity> findByAuthor(User author, Pageable pageable);

    Page<AnswerEntity> findByMarkedAsSolutionTrue(Pageable pageable);

}
