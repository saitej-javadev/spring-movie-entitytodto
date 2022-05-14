package com.saitej.movie.entitytodto.repos;

import com.saitej.movie.entitytodto.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByName(String name);

    @Query(name = "select * from movie as m where m.language=:name",nativeQuery = true)
   Movie findByLanguage(@Param("name") String name);


}
