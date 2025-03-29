package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.Post;
import com.exercises.Foro_HubH2.infrastructure.common.entity.dto.PostDto;

public class PostDtoMapper {
    public static PostDto postToDto(Post post) {

        return new PostDto(post.getPostId(), post.getTitle(), post.getMessage(), post.getCreationDate(),
                post.getIsSolved(), post.getAuthor(), post.getTag());
    }
}
