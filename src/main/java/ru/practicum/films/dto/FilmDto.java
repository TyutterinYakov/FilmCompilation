package ru.practicum.films.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Информация о фильме")
public class FilmDto {

    @Schema(description = "Идентификатор фильма")
    private Long id;
    @Schema(description = "Название фильма")
    private String title;
    @Schema(description = "Описание фильма")
    private String description;
    @Schema(description = "Адрес изображения фильма")
    private String imageUrl;
    @Schema(description = "Адрес превью фильма")
    private String previewUrl;
    @Schema(description = "Адрес стрима фильма")
    private String recordUrl;
    @Schema(description = "Название жанра фильма")
    private String genre;
    @Schema(description = "Флаг рекомендации фильма")
    private boolean recommended;
    @Schema(description = "Дополнительные детали фильма")
    private Detail details;
    @Schema(description = "Рейтинг фильма")
    private double rating;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Schema(description = "Дополнительные детали фильма")
    public static class Detail {
        @Schema(description = "Год выхода фильма")
        private int yearOfIssue;
        @Schema(description = "Продолжительность фильма")
        private int duration;
    }
}
