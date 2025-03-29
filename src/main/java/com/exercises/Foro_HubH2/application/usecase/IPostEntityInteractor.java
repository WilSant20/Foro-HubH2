package com.exercises.Foro_HubH2.application.usecase;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface IPostEntityInteractor {

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(Post post);

    Post findByPostId(Long id);

    PageResponse<Post> findByTags(Tag tag, Pageable pageable);

    PageResponse<Post> findByAuthor(User author, Pageable pageable);

    PageResponse<Post> findByIsSolved(Boolean bool, Pageable pageable);

    PageResponse<Post> findByCreationDateInRange(LocalDateTime begin, LocalDateTime end, Pageable pageable);

    PageResponse<Post> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    PageResponse<Post> findByMessageContainsIgnoreCase(String message, Pageable pageable);

    PageResponse<Post> findAll(Pageable pageable);



}
