package com.example.alkemy_disney.entities;

import com.example.alkemy_disney.DTO.PeliculaCompletoDto;
import com.example.alkemy_disney.DTO.PersonajeCompletoDto;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String nombre;
    private String historia;
    private int edad;
    private float peso;


    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private List<Pelicula> peliculas;

    private static ModelMapper mapper = new ModelMapper();

    public static Personaje mapToEntity(PersonajeCompletoDto personajeCompletoDto) throws Exception{
        try{
            Personaje personaje = mapper.map(personajeCompletoDto, Personaje.class);
            return personaje;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<Personaje> mapToEntityList(List<PersonajeCompletoDto> personajeCompletoDtosList) throws Exception{
        try {
            List<Personaje> personajes = new ArrayList<>();
            for (PersonajeCompletoDto p : personajeCompletoDtosList) {
                personajes.add(mapToEntity(p));
            }
            return personajes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
