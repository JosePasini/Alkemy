package com.example.alkemy_disney.repositories;

import com.example.alkemy_disney.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends BaseRepository<Personaje, Long> {

    // Query con JPQL
    @Query(value = "SELECT p.nombre, p.imagen FROM Personaje p")
    List<Personaje> obtener_imagen_y_nombre();

/*
    @Query(
            value = "SELECT * FROM Personaje p WHERE p.nombre LIKE %:filtro%",
            nativeQuery = true
        )
    List<Personaje> buscar_personaje(@Param("filtro") String filtro);
*/
    @Query(
            value = "SELECT * FROM Personaje p WHERE p.nombre LIKE %:filtro% OR p.imagen LIKE %:filtro%",
            nativeQuery = true
    )
    List<Personaje> buscar_personaje(@Param("filtro") String filtro);



/*
    @Query(
            value = "SELECT * FROM Personaje p WHERE p.nombre LIKE %:filtroNombre%"
    )
    List<Personaje> buscar_personaje_filtro_avanzado(@Param("filtroNombre") String filtroNombre, @Param("filtroEdad") int filtroEdad);//, @Param("filtroPelicula") String filtroPelicula);
*/


}
