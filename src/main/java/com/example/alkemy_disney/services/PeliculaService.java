package com.example.alkemy_disney.services;

import com.example.alkemy_disney.entities.Pelicula;


import java.util.List;

public interface PeliculaService extends BaseService<Pelicula, Long>{
    public List<Pelicula> obtener_peliculas() throws Exception;

}
