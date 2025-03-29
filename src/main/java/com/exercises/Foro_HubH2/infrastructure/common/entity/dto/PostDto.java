package com.exercises.Foro_HubH2.infrastructure.common.entity.dto;

import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.domain.models.User;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto (
        Long PostId,
        String title,
        String Message,
        LocalDateTime creationDate,
        Boolean isSolved,
        User author,
        Tag Tag
){
//
//    Long PostId;
//    String title;
//    String Message;
//    LocalDateTime creationDate;
//    Boolean isSolved;
//    User author;
//    List<String>Tags;
//
//    public PostDto(Long postId, String title, String message, LocalDateTime creationDate, Boolean isSolved, User author, List<String> tags) {
//        PostId = postId;
//        this.title = title;
//        Message = message;
//        this.creationDate = creationDate;
//        this.isSolved = isSolved;
//        this.author = author;
//        Tags = tags;
//    }
}
