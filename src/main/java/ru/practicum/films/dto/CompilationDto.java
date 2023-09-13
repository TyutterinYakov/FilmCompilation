package ru.practicum.films.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Подборка")
public class CompilationDto {
    @Schema(description = "Идентификатор подборки")
    private long id;
    @Schema(description = "Название подборки")
    private String title;
}
