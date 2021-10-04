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
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaSaveDto {
    private Long id;


    private String imagen;
    private String titulo;
    private Date fecha;
    private int calificacion;

    private List<Personaje> personajes;

    private Genero genero;

    private static ModelMapper mapper = new ModelMapper();

    public static PeliculaSaveDto mapToDto(Pelicula pelicula){
        PeliculaSaveDto peliculaSaveDto = mapper.map(pelicula, PeliculaSaveDto.class);
        return peliculaSaveDto;
    }

    public static List<PeliculaSaveDto> mapToDtoList(List<Pelicula> peliculaList){
        List<PeliculaSaveDto> peliculas = new ArrayList<>();
        for (Pelicula p: peliculaList){
            peliculas.add(mapToDto(p));
        }
        return peliculas;
    }

}



