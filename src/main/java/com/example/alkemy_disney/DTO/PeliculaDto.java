package com.example.alkemy_disney.DTO;

import com.example.alkemy_disney.entities.Pelicula;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String imagen;
    private String titulo;
    private Date fecha;

    private static ModelMapper mapper = new ModelMapper();

    public static PeliculaDto mapToDto(Pelicula pelicula){
        PeliculaDto peliculaDto = mapper.map(pelicula, PeliculaDto.class);
        return peliculaDto;
    }

    public static List<PeliculaDto> mapToDtoList(List<Pelicula> peliculaList){
        List<PeliculaDto> peliculas = new ArrayList<>();
        for (Pelicula p: peliculaList){
            peliculas.add(mapToDto(p));
        }
        return peliculas;
    }

}
