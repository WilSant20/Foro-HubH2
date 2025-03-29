package com.exercises.Foro_HubH2.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tag {
    private Long id;
    private String name;
    private String info;
}
