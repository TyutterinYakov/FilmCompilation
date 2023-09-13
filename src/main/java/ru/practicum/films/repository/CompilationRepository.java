package ru.practicum.films.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.films.model.Compilation;

import java.util.Set;

public interface CompilationRepository extends JpaRepository<Compilation, Long> {

    @Query(value = "select * from compilations c left join compilations_films cf ON " +
            "cf.compilation_id = c.id where cf.film_id IN (?1)", nativeQuery = true)
    Set<Compilation> findAllByFilmIds(Set<Long> films);
}
