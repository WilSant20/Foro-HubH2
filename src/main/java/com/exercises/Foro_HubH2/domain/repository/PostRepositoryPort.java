package com.exercises.Foro_HubH2.domain.repository;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;

import java.time.LocalDateTime;

public interface PostRepositoryPort {
    Post create(Post post);

    void delete(Post post);

    Post update(Post post);

    PageResponse<Post> findAll(int page, int size);

    Post findByPostId(Long id);

    PageResponse<Post> findByTitleContainsIgnoreCase(String title, int page, int size);

    PageResponse<Post> findByMessageContainsIgnoreCase(String messagePiece, int page, int size);

    PageResponse<Post> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, int page, int size);

    PageResponse<Post> findByIsSolvedEqualsTrue(int page, int size);

    PageResponse<Post> findByAuthor(User author, int page, int size);

    PageResponse<Post> findByTags(Tag tag, int page, int size);



}
