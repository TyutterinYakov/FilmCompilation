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
@Schema(description = "Служит для передачи идентификатора фильма и подборки")
public class AddFilmToCompilation {

    @Schema(description = "Идентификатор фильма")
    private long filmId;
    @Schema(description = "Идентификатор подборки")
    private long collectionId;
}
