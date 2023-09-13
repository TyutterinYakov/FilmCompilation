package ru.practicum.films.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "films")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String title;
    private String description;
    private String imageUrl;
    private String previewUrl;
    private String recordUrl;
    private String genre;
    private boolean recommended;
    private int yearOfIssue;
    private int duration;
    private double rating;

    @ManyToMany(mappedBy = "films")
    private Set<Compilation> compilations;
}
