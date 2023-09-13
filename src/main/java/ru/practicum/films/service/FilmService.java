package ru.practicum.films.service;

import ru.practicum.films.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> getAll(String genre);


}
