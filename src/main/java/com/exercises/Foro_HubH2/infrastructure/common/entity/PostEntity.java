package com.exercises.Foro_HubH2.infrastructure.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("posts")
public class PostEntity {
    @Id
    private Long PostId;
    private String title;
    private String Message;
    private LocalDateTime creationDate;
    private Boolean isSolved = false;
    private UserEntity author;
    private TagEntity Tag;
}
