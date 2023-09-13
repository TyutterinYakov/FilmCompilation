package ru.practicum.films.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FilmsDto {

    @Schema(description = "Идентификаторы фильмов для получения их подборок")
    private Set<Long> filmIds;
}
