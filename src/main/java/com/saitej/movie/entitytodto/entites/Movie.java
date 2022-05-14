package com.saitej.movie.entitytodto.entites;



import com.saitej.movie.entitytodto.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String language;
    @Embedded
    private Cast cast;

    public static MovieDTO convertMovieEntitytoMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setLanguage(movie.getLanguage());
        movieDTO.setDirector(movie.getCast().getDirector());
        movieDTO.setActor(movie.getCast().getActor());
        movieDTO.setActress(movie.getCast().getActress());
        return movieDTO;
    }

    public static List<MovieDTO> convertEntitiesToDTOs(List<Movie> movies) {
        return movies.stream().map(Movie::convertMovieEntitytoMovieDTO).collect(Collectors.toList());
    }
}


