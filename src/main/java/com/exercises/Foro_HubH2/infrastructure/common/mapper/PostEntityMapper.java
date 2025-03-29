package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.infrastructure.common.entity.PostEntity;

import java.util.stream.Collectors;

public class PostEntityMapper {
    public static Post fromEntityToPost(PostEntity post) {
        return new Post(post.getPostId(), post.getTitle(), post.getMessage(), post.getCreationDate(),
                post.getIsSolved(), UserEntityMapper.fromEntityToUser(post.getAuthor()),
                TagEntityMapper.fromEntityToTag(post.getTag()));
    }

    public static PostEntity fromPostToEntity(Post post) {
        return new PostEntity(post.getPostId(), post.getTitle(), post.getMessage(), post.getCreationDate(),
                post.getIsSolved(), UserEntityMapper.fromUserToEntity(post.getAuthor()),
                TagEntityMapper.fromTagToEntity(post.getTag()));
    }
}
