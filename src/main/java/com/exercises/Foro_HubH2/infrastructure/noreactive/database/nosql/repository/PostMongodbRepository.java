package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository;

import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.infrastructure.common.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PostMongodbRepository extends MongoRepository<PostEntity, Long> {


    Page<PostEntity> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    Page<PostEntity> findByMessageContainsIgnoreCase(String messagePiece, Pageable pageable);

    @Query("{ 'creationDate' : { $gte: ?0, $lte: ?1 } }")
    Page<PostEntity> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, Pageable pageable);

    Page<PostEntity> findByIsSolvedTrue(Pageable pageable);

    Page<PostEntity> findByAuthor(User author, Pageable pageable);

    Page<PostEntity> findByTag(Pageable pageable);

}
