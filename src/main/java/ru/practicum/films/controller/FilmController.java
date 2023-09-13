package ru.practicum.films.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.films.dto.FilmDto;
import ru.practicum.films.mapper.FilmMapper;
import ru.practicum.films.service.FilmService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/list")
    @Operation(summary = "Получение фильмов с возможностью фильтрации")
    @Parameter(name = "genre", description = "Название жанра")
    @ApiResponse(responseCode = "200", description = "Описание фильмов",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FilmDto.class))))
    public List<FilmDto> getAllByGenre(@RequestParam(required = false) String genre) {
        return FilmMapper.toDto(filmService.getAll(genre));
    }

}
