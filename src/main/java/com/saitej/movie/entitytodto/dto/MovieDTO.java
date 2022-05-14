package com.saitej.movie.entitytodto.dto;


import com.saitej.movie.entitytodto.entites.Cast;
import com.saitej.movie.entitytodto.entites.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
    private Long id;
    private String name;
    private String language;
    private String director;
    private String actor;
    private String actress;

    public static Movie convertMovieDTOtoMovieEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setName(movieDTO.getName());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setCast(new Cast(movieDTO.getDirector(), movieDTO.getActor(), movieDTO.getActress()));
        return movie;

    }
}
