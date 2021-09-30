package com.example.alkemy_disney.DTO;

import com.example.alkemy_disney.entities.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String imagen;
    private String nombre;

    private static ModelMapper mapper = new ModelMapper();

    private static PersonajeDto mapToDto(Personaje personaje){
        PersonajeDto personajeDto = mapper.map(personaje, PersonajeDto.class);
        return personajeDto;
    }

    public static List<PersonajeDto> mapToDtoList(List<Personaje> personajeList){
        List<PersonajeDto> personajes = new ArrayList<PersonajeDto>();
        for (Personaje p: personajeList) {
            personajes.add(mapToDto(p));
        }
        return personajes;
    }


}
