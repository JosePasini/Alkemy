package com.example.alkemy_disney.entities;

import com.example.alkemy_disney.DTO.PeliculaCompletoDto;
import com.example.alkemy_disney.DTO.PeliculaSaveDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;
    private String titulo;
    private Date fecha;

    @Min(value = 1, message = "El mínimo es 1")
    @Max(value = 5, message = "El máximo es 5")
    private int calificacion;



    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "peliculas",cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Personaje> personajes;



    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "genero")
    private Genero genero;


    private static ModelMapper mapper = new ModelMapper();

    public static Pelicula mapToEntity(PeliculaCompletoDto peliculaCompletoDto) throws Exception {
        try {
            Pelicula pelicula = mapper.map(peliculaCompletoDto, Pelicula.class);
            return pelicula;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Pelicula mapToEntity(PeliculaSaveDto peliculaSaveDto) throws Exception {
        try {
            Pelicula pelicula = mapper.map(peliculaSaveDto, Pelicula.class);
            return pelicula;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static List<Pelicula> mapToEntityList(List<PeliculaCompletoDto> peliculaCompletoDto) throws Exception {
        try {
            List<Pelicula> peliculas = new ArrayList<>();
            for (PeliculaCompletoDto p : peliculaCompletoDto) {
                peliculas.add(mapToEntity(p));
            }
            return peliculas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



}
