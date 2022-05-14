package com.saitej.movie.entitytodto.services;
import com.saitej.movie.entitytodto.dto.MovieDTO;
import java.util.List;


public interface MovieService {

    MovieDTO saveMovie(MovieDTO movie);
    MovieDTO findMovieById(Long id);
    List<MovieDTO> getAllMovies();
    MovieDTO updateMovie(MovieDTO movieDTO);
    void deleteMovieById(Long id);
    MovieDTO findByName(String name);
    MovieDTO findByLanguage(String name);

}
