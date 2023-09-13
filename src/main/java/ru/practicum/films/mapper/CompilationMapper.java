package ru.practicum.films.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.films.dto.CompilationDto;
import ru.practicum.films.dto.NewCompilationDto;
import ru.practicum.films.model.Compilation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CompilationMapper {

    public Compilation toModel(NewCompilationDto newCompilationDto) {
        return Compilation.builder().title(newCompilationDto.getCollectionName()).build();
    }

    public CompilationDto toDto(Compilation compilation) {
        return CompilationDto.builder()
                .id(compilation.getId())
                .title(compilation.getTitle())
                .build();
    }

    public List<CompilationDto> toDto(Collection<Compilation> compilations) {
        return compilations.stream().map(CompilationMapper::toDto).collect(Collectors.toList());
    }
}
