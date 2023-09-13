package ru.practicum.films.service;

import ru.practicum.films.dto.CompilationDto;
import ru.practicum.films.dto.FilmsDto;
import ru.practicum.films.dto.NewCompilationDto;
import ru.practicum.films.model.Compilation;

import java.util.Collection;
import java.util.Set;

public interface CompilationService {

    CompilationDto create(NewCompilationDto newCompilationDto);

    void addFilmToCompilation(Long collectionId, Long filmId);

    Set<Compilation> getAll(Set<Long> filmIds);
}
