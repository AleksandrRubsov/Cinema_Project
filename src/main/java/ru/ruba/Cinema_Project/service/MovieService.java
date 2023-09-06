package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
