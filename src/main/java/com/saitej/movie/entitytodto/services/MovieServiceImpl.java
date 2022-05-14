package com.saitej.movie.entitytodto.services;
import com.saitej.movie.entitytodto.dto.MovieDTO;
import com.saitej.movie.entitytodto.entites.Cast;
import com.saitej.movie.entitytodto.entites.Movie;
import com.saitej.movie.entitytodto.repos.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = movieRepository.save(MovieDTO.convertMovieDTOtoMovieEntity(movieDTO));
        return Movie.convertMovieEntitytoMovieDTO(movie);
    }

    @Override
    public MovieDTO findMovieById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        return Movie.convertMovieEntitytoMovieDTO(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return Movie.convertEntitiesToDTOs(movies);
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(movieDTO.getId()).get();
        movie.setId(movieDTO.getId());
        movie.setName(movieDTO.getName());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setCast(new Cast(movieDTO.getDirector(), movieDTO.getActor(), movieDTO.getActress()));
        Movie moviefrmDb = movieRepository.save(movie);
        return Movie.convertMovieEntitytoMovieDTO(moviefrmDb);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
        log.info("Logging the deleted movie: {} ", id);
    }

    @Override
    public MovieDTO findByName(String name) {
        Movie movie = movieRepository.findByName(name);
        return Movie.convertMovieEntitytoMovieDTO(movie);
    }

    @Override
    public MovieDTO findByLanguage(String name) {
         Movie movie = movieRepository.findByLanguage(name);
        return Movie.convertMovieEntitytoMovieDTO(movie);
    }
}
