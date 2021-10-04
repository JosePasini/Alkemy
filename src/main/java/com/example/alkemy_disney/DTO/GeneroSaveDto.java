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
public class GeneroSaveDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String imagen;

    //@JsonIgnoreProperties(value = {"genero", "personajes"})
    @JsonIgnoreProperties(value = {"personajes"})
    private List<Pelicula> peliculas;

    private static ModelMapper mapper = new ModelMapper();

    public static GeneroSaveDto mapToDto(Genero genero){
        GeneroSaveDto generoDto = mapper.map(genero, GeneroSaveDto.class);
        return generoDto;
    }

    public static List<GeneroSaveDto> mapToDtoList(List<Genero> generos){
        List<GeneroSaveDto> generoDtoList = new ArrayList<>();
        for (Genero g : generos){
            generoDtoList.add(mapToDto(g));
        }
        return generoDtoList;
    }

}