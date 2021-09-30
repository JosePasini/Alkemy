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
public class PeliculaCompletoDto {
    private Long id;


    private String imagen;
    private String titulo;
    private Date fecha;
    private int calificacion;

    @JsonIgnoreProperties(value = "peliculas")
    private List<Personaje> personajes;

    @JsonIgnoreProperties(value = "peliculas")
    private Genero genero;

    private static ModelMapper mapper = new ModelMapper();

    public static PeliculaCompletoDto mapToDto(Pelicula pelicula){
        PeliculaCompletoDto peliculaCompletoDto = mapper.map(pelicula, PeliculaCompletoDto.class);
        return peliculaCompletoDto;
    }

    public static List<PeliculaCompletoDto> mapToDtoList(List<Pelicula> peliculaList){
        List<PeliculaCompletoDto> peliculas = new ArrayList<>();
        for (Pelicula p: peliculaList){
            peliculas.add(mapToDto(p));
        }
        return peliculas;
    }

}
