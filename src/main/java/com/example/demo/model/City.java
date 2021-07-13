package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3,max = 10)
    private String name;

    @ManyToOne
    private Country country;

    @Min(0)
    private int area;
    @Min(0)
    private int population;
    @Min(0)
    private int gdp;

    private String description;

}
