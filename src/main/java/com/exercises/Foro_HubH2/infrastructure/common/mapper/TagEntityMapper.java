package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.models.Tag;
import com.exercises.Foro_HubH2.infrastructure.common.entity.TagEntity;

public class TagEntityMapper {
    public static TagEntity fromTagToEntity(Tag tag) {
        return new TagEntity(tag.getId(), tag.getName(), tag.getInfo());
    }

    public static Tag fromEntityToTag(TagEntity tag) {
        return new Tag(tag.getId(), tag.getName(), tag.getInfo());
    }
}
