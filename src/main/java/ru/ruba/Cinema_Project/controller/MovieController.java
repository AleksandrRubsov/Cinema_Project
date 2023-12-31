package ru.ruba.Cinema_Project.controller;

import ru.ruba.Cinema_Project.dto.request.MovieRequestDto;
import ru.ruba.Cinema_Project.dto.response.MovieResponseDto;
import ru.ruba.Cinema_Project.model.Movie;
import ru.ruba.Cinema_Project.service.MovieService;
import ru.ruba.Cinema_Project.service.mapper.RequestDtoMapper;
import ru.ruba.Cinema_Project.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final RequestDtoMapper<MovieRequestDto, Movie> movieRequestDtoMapper;
    private final ResponseDtoMapper<MovieResponseDto, Movie> movieResponseDtoMapper;

    public MovieController(MovieService movieService,
                           RequestDtoMapper<MovieRequestDto, Movie> movieRequestDtoMapper,
                           ResponseDtoMapper<MovieResponseDto, Movie> movieResponseDtoMapper) {
        this.movieService = movieService;
        this.movieRequestDtoMapper = movieRequestDtoMapper;
        this.movieResponseDtoMapper = movieResponseDtoMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody @Valid MovieRequestDto requestDto) {
        Movie movie = movieService.add(movieRequestDtoMapper.mapToModel(requestDto));
        return movieResponseDtoMapper.mapToDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}