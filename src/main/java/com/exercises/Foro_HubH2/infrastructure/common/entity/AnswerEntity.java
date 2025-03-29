package com.exercises.Foro_HubH2.infrastructure.common.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("answers")
public class AnswerEntity {
    @Id
    private Long AnswerId;
    private String message;
    private PostEntity post;
    private LocalDateTime creationDate;
    private UserEntity author;
    private Boolean markedAsSolution = false;

}
