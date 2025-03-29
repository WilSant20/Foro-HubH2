package com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.adapter;

import com.exercises.Foro_HubH2.domain.common.PageResponse;
import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;
import com.exercises.Foro_HubH2.domain.repository.PostRepositoryPort;
import com.exercises.Foro_HubH2.infrastructure.common.entity.PostEntity;
import com.exercises.Foro_HubH2.infrastructure.common.entity.TagEntity;
import com.exercises.Foro_HubH2.infrastructure.common.mapper.PostEntityMapper;
import com.exercises.Foro_HubH2.infrastructure.exceptions.ResourceNotFoundException;
import com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository.PostMongodbRepository;
import com.exercises.Foro_HubH2.infrastructure.noreactive.database.nosql.repository.TagMongoDbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostRepositoryAdapter implements PostRepositoryPort {

    private final PostMongodbRepository postRepository;
    private final TagMongoDbRepository tagRepository;

    @Override
    public Post create(Post post) {
        PostEntity post1 = PostEntityMapper.fromPostToEntity(post);
        return PostEntityMapper.fromEntityToPost(postRepository.save(post1));
    }

    @Override
    public void delete(Post post) {
        PostEntity post1 = PostEntityMapper.fromPostToEntity(post);
        postRepository.delete(post1);
    }

    @Override
    public Post update(Post post) {
        PostEntity post1 = postRepository.findById(post.getPostId()).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found"+post.getPostId()));
        TagEntity tag = tagRepository.findById(post.getTag().getId()).orElseThrow(()-> new ResourceNotFoundException(
                "Tag not found"));
        if (post.getTag()!=null && (!post.getTag().getId().equals(tag.getId()))) {
            post1.setTag(tag);
        }
        Optional.ofNullable(post.getTitle())
                .ifPresent(post1::setTitle);
        Optional.ofNullable(post.getMessage())
                .ifPresent(post1::setMessage);
        Optional.ofNullable(post.getIsSolved())
                .ifPresent(post1::setIsSolved);
        return PostEntityMapper.fromEntityToPost(post1);
    }

    @Override
    public PageResponse<Post> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findAll(pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public Post findByPostId(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post not found, id: " + id));
        return PostEntityMapper.fromEntityToPost(post);
    }

    @Override
    public PageResponse<Post> findByTitleContainsIgnoreCase(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByTitleContainsIgnoreCase(title, pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Post> findByMessageContainsIgnoreCase(String messagePiece, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByMessageContainsIgnoreCase(messagePiece, pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Post> findByCreationDateInRange(LocalDateTime beginDate, LocalDateTime endDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByCreationDateInRange(beginDate, endDate, pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Post> findByIsSolvedEqualsTrue(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByIsSolvedTrue(pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Post> findByAuthor(User author, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByAuthor(author, pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }

    @Override
    public PageResponse<Post> findByTags(Tag tag, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> page1 = postRepository.findByTag(pageable);
        return new PageResponse<>(page1.getContent().stream().map(PostEntityMapper::fromEntityToPost).collect(Collectors.toList()), page1.getNumber(), page1.getSize(), page1.getTotalElements(), page1.getTotalPages());
    }
}
