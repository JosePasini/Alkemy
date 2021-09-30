package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.entities.Pelicula;
import com.example.alkemy_disney.services.PeliculaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/peliculas")
public class PeliculaController extends BaseControllerImpl<Pelicula, PeliculaServiceImpl> {

    @GetMapping(value = "/movies")
    public ResponseEntity<?> obtener_peliculas() throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.obtener_peliculas());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
