package ru.practicum.films.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.films.model.Film;
import ru.practicum.films.repository.FilmRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    @Override
    public List<Film> getAll(String genre) {
        if (genre != null && !genre.isBlank()) {
            return filmRepository.findAllByGenre(genre);
        } else {
            return filmRepository.findAll();
        }
    }
}
