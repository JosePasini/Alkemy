package com.example.alkemy_disney.entities;

import com.example.alkemy_disney.DTO.GeneroDto;
import com.example.alkemy_disney.DTO.GeneroSaveDto;
import lombok.*;
import org.modelmapper.ModelMapper;

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
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Pelicula> peliculas;

    private static ModelMapper mapper = new ModelMapper();

    public static Genero mapToEntity(GeneroSaveDto generoDto) throws Exception {
        try {
            Genero genero = mapper.map(generoDto, Genero.class);
            return genero;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static List<Genero> mapToEntityList(List<GeneroSaveDto> generoDtoList) throws Exception {
        try {
            List<Genero> generos = new ArrayList<>();
            for (GeneroSaveDto g: generoDtoList) {
                generos.add(mapToEntity(g));
            }
            return generos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
