package com.exercises.Foro_HubH2.infrastructure.common.mapper;

import com.exercises.Foro_HubH2.domain.common.PageResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageResponseConverter {

    public static <E, D> PageResponse<D> convertPage(
            PageResponse<E> sourcePage,
            Function<E, D> mapper) {

        List<D> convertedList = sourcePage.getContent()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());

        return new PageResponse<>(
                convertedList,
                sourcePage.getPage(),
                sourcePage.getSize(),
                sourcePage.getTotalElements(),
                sourcePage.getTotalPages()
        );
    }
}
