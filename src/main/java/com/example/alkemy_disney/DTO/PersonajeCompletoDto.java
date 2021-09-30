package com.example.alkemy_disney.DTO;

import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.entities.Pelicula;
import com.example.alkemy_disney.entities.Personaje;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeCompletoDto {
    private Long id;
    private String imagen;
    private String nombre;
    private String historia;
    private int edad;
    private float peso;


    @JsonIgnoreProperties(value = {"personajes", "genero"})
    private List<Pelicula> peliculas;


    private static ModelMapper mapper = new ModelMapper();

    public static PersonajeCompletoDto mapToDto(Personaje personaje) throws Exception{
        try {
            PersonajeCompletoDto personajeCompletoDto = mapper.map(personaje, PersonajeCompletoDto.class);
            return personajeCompletoDto;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<PersonajeCompletoDto> mapToDtoList(List<Personaje> personajeList) throws Exception{
        try {
            List<PersonajeCompletoDto> personajes = new ArrayList<>();
            for (Personaje p : personajeList){
                personajes.add(mapToDto(p));
            }
            return personajes;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
