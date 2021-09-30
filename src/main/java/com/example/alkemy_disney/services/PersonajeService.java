package com.example.alkemy_disney.services;

import com.example.alkemy_disney.DTO.PersonajeDto;
import com.example.alkemy_disney.entities.Personaje;

import java.util.List;

public interface PersonajeService extends BaseService<Personaje, Long> {
    List<Personaje> buscar_personaje() throws Exception;
    List<Personaje> buscar_personajes_completos() throws Exception;

}
