package com.exercises.Foro_HubH2.infrastructure.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("tags")
public class TagEntity {
    @Id
    private Long id;
    private String name;
    private String info;
}
