package com.exercises.Foro_HubH2.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Answer {
    private Long AnswerId;
    private String message;
    private Post post;
    private LocalDateTime creationDate;
    private User author;
    private Boolean markedAsSolution;
}
