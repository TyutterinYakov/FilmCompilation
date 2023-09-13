package ru.practicum.films.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.films.dto.FilmDto;
import ru.practicum.films.model.Film;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class FilmMapper {


    public FilmDto toDto(Film film) {
        return FilmDto.builder()
                .id(film.getId())
                .details(new FilmDto.Detail(film.getYearOfIssue(), film.getDuration()))
                .genre(film.getGenre())
                .title(film.getTitle())
                .rating(film.getRating())
                .description(film.getDescription())
                .previewUrl(film.getPreviewUrl())
                .recommended(film.isRecommended())
                .recordUrl(film.getRecordUrl())
                .imageUrl(film.getImageUrl())
                .build();
    }

    public List<FilmDto> toDto(List<Film> films) {
        return films.stream().map(FilmMapper::toDto).collect(Collectors.toList());
    }
}
