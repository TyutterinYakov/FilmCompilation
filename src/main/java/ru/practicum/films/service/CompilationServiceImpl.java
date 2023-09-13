package ru.practicum.films.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.films.dto.CompilationDto;
import ru.practicum.films.dto.NewCompilationDto;
import ru.practicum.films.mapper.CompilationMapper;
import ru.practicum.films.model.Compilation;
import ru.practicum.films.model.Film;
import ru.practicum.films.repository.CompilationRepository;
import ru.practicum.films.repository.FilmRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {

    private final CompilationRepository compilationRepository;
    private final FilmRepository filmRepository;

    @Override
    public CompilationDto create(NewCompilationDto newCompilationDto) {

        Compilation compilation = CompilationMapper.toModel(newCompilationDto);

        return CompilationMapper.toDto(compilationRepository.save(compilation));
    }

    @Override
    @Transactional
    public void addFilmToCompilation(Long collectionId, Long filmId) {
        Compilation compilation = compilationRepository.findById(collectionId).orElseThrow(() ->
                new RuntimeException("Отсутствует подборка с идентификатором " + collectionId));

        Film film = filmRepository.findById(filmId).orElseThrow(() ->
                new RuntimeException("Отсутствует фильм с идентификатором " + filmId));

        compilation.getFilms().add(film);
    }

    @Override
    public Set<Compilation> getAll(Set<Long> filmIds) {
        return compilationRepository.findAllByFilmIds(filmIds);
    }

}
