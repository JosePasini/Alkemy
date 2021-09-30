package com.example.alkemy_disney.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String imagen;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();

}
