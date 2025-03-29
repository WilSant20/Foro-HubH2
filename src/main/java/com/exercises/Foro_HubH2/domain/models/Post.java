package com.exercises.Foro_HubH2.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private Long PostId;
    private String title;
    private String Message;
    private LocalDateTime creationDate;
    private Boolean isSolved;
    private User author;
    private Tag Tag;

}
