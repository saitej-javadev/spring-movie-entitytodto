package com.saitej.movie.entitytodto;
import com.saitej.movie.entitytodto.dto.MovieDTO;
import com.saitej.movie.entitytodto.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MovieRestapiDtoexApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MovieRestapiDtoexApplication.class, args);
        MovieService movieService = run.getBean(MovieService.class);

        MovieDTO movieDTO1 =
                new MovieDTO().builder()
                .id(1L)
                .name("Titanic").language("English").director("James Cameron").actor("Leonardo-Decaprio").actress("Kate winslet").build();

        MovieDTO movieDTO2 =
                new MovieDTO().builder()
                        .id(2L)
                        .name("KGF").language("Kannada").director("Prashanth Neel").actor("Yash").actress("Shetty").build();


        movieService.saveMovie(movieDTO1);
        movieService.saveMovie(movieDTO2);

        MovieDTO movieDTO = movieService.findMovieById(1L);
        log.info("Logging Movie: {} ", movieDTO);


        movieService.getAllMovies().forEach(System.out::println);


        movieDTO2.setLanguage("Telugu");
        movieService.updateMovie(movieDTO2);
        System.out.println(movieDTO2);

      //  movieService.deleteMovieById(2L);


     //   System.out.println(movieService.findByName("Titanic"));

     //   movieService.getAllMovies().forEach(System.out::println);

        System.out.println(movieService.findByLanguage("English"));
    }

}
