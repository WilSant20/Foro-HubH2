package com.exercises.Foro_HubH2.application.usecase.impl;

import com.exercises.Foro_HubH2.application.usecase.IPostEntityInteractor;
import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.PostRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class PostEntityInteractorImpl implements IPostEntityInteractor {

    private PostRepositoryPort repository;

    @Override
    public Post createPost(Post post) {
        return repository.create(post);
    }

    @Override
    public Post updatePost(Post post) {
        return repository.update(post);
    }

    @Override
    public void deletePost(Post post) {
        repository.delete(post);
    }

    @Override
    public Post findByPostId(Long id) {
        return repository.findByPostId(id);
    }

    @Override
    public PageResponse<Post> findByTags(Tag tag, Pageable pageable) {
        return repository.findByTags(tag, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findByAuthor(User author, Pageable pageable) {
        return repository.findByAuthor(author, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findByIsSolved(Boolean bool, Pageable pageable) {
        return repository.findByIsSolvedEqualsTrue(pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findByCreationDateInRange(LocalDateTime begin, LocalDateTime end, Pageable pageable) {
        return repository.findByCreationDateInRange(begin, end, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findByTitleContainsIgnoreCase(String title, Pageable pageable) {
        return repository.findByTitleContainsIgnoreCase(title, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findByMessageContainsIgnoreCase(String message, Pageable pageable) {
        return repository.findByMessageContainsIgnoreCase(message, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PageResponse<Post> findAll(Pageable pageable) {
        return repository.findAll(pageable.getPageNumber(), pageable.getPageSize());
    }
}
