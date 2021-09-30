package com.example.alkemy_disney.repositories;

import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends BaseRepository<Pelicula, Long> {

    @Query(value = "SELECT p.imagen, p.titulo FROM Pelicula p")
    List<Pelicula> obtener_peliculas();

}
