package ru.practicum.films.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.films.model.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByGenre(String genre);

}
