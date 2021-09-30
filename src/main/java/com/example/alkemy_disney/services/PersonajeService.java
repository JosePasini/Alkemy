package com.example.alkemy_disney.services;

import com.example.alkemy_disney.entities.Personaje;

import java.util.List;

public interface PersonajeService extends BaseService<Personaje, Long> {
    List<Personaje> obtener_imagen_y_nombre() throws Exception;
    List<Personaje> buscar_personaje(String filtro) throws Exception;
    //List<Personaje> buscar_personaje(String filtroNombre, int filtroEdad) throws Exception;

}
