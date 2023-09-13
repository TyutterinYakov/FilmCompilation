package ru.practicum.films.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.films.dto.*;
import ru.practicum.films.mapper.CompilationMapper;
import ru.practicum.films.service.CompilationService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class CompilationController {

    private final CompilationService compilationService;

    @PostMapping("/collection/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание подборки")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Параметры подборки", content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = NewCompilationDto.class)))
    @ApiResponse(responseCode = "201", description = "Подборка создана",
            content = @Content(schema = @Schema(implementation = CompilationDto.class)))
    public CompilationDto create(@RequestBody NewCompilationDto newCompilationDto) {
        return compilationService.create(newCompilationDto);
    }

    @PostMapping("/collection/add")
    @Operation(summary = "Добавление фильма в подборку")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Идентификаторы фильма и подборки", content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = AddFilmToCompilation.class)))
    @ApiResponse(responseCode = "200", description = "Фильм успешно добавлен")
    public void addFilmToCompilation(@RequestBody AddFilmToCompilation addFilmToCompilation) {
        compilationService.addFilmToCompilation(addFilmToCompilation.getCollectionId(),
                addFilmToCompilation.getFilmId());
    }

    @GetMapping("/collections/films")
    @Operation(summary = "Получение подборок, в которое входят перечисленные фильмы")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Список идентификаторов фильмов", content =
    @Content(mediaType = "application/json", schema = @Schema(implementation = FilmsDto.class)))
    @ApiResponse(responseCode = "200", description = "Описание фильмов",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FilmDto.class))))
    public List<CompilationDto> getAllByFilms(@RequestBody FilmsDto filmsDto) {
        return CompilationMapper.toDto(compilationService.getAll(filmsDto.getFilmIds()));
    }
}
