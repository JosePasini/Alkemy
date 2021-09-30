package com.example.alkemy_disney.DTO;

import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.entities.Pelicula;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String imagen;

    @JsonIgnoreProperties(value = {"genero", "personajes"})
    private List<Pelicula> peliculas;

    private static ModelMapper mapper = new ModelMapper();

    public static GeneroDto mapToDto(Genero genero){
        GeneroDto generoDto = mapper.map(genero, GeneroDto.class);
        return generoDto;
    }

    public static List<GeneroDto> mapToDtoList(List<Genero> generos){
        List<GeneroDto> generoDtoList = new ArrayList<>();
        for (Genero g : generos){
            generoDtoList.add(mapToDto(g));
        }
        return generoDtoList;
    }

}
