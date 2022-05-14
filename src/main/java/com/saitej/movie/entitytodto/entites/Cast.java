package com.saitej.movie.entitytodto.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Cast {

    private String director;
    private String actor;
    private String actress;

}


