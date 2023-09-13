package ru.practicum.films.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "compilations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Compilation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    @JoinTable(name = "compilations_films",
            joinColumns = @JoinColumn(name = "compilation_id"),
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Set<Film> films;
}
