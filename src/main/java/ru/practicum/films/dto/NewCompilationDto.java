package ru.practicum.films.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Новая подборка")
public class NewCompilationDto {

    @Schema(description = "Название подборки")
    private String collectionName;

}
