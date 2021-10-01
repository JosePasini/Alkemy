package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.DTO.PeliculaCompletoDto;
import com.example.alkemy_disney.DTO.PeliculaDto;
import com.example.alkemy_disney.entities.Pelicula;
import com.example.alkemy_disney.services.PeliculaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/peliculas")
public class PeliculaController extends BaseControllerImpl<Pelicula, PeliculaServiceImpl> {

    @GetMapping(value = "/movies")
    public ResponseEntity<?> obtener_peliculas() throws Exception{
        try{
            List<Pelicula> peliculaList = servicio.findAll();
            List<PeliculaDto> peliculaDtos = PeliculaDto.mapToDtoList(peliculaList);
            return ResponseEntity.status(HttpStatus.OK).body(peliculaDtos);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping(value = "/view_all")
    public ResponseEntity<?> obtener_peliculas_completo() throws Exception{
        try{
            List<Pelicula> peliculaList = servicio.findAll();
            List<PeliculaCompletoDto> peliculaCompletoDtos = PeliculaCompletoDto.mapToDtoList(peliculaList);
            return ResponseEntity.status(HttpStatus.OK).body(peliculaCompletoDtos);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping(value = "/save_pelicula")
    public ResponseEntity<?> guardar_pelicula_completa(@RequestBody PeliculaCompletoDto peliculaCompletoDto) throws Exception{
        try{
            Pelicula pelicula = Pelicula.mapToEntity(peliculaCompletoDto);
            this.servicio.save(pelicula);
            PeliculaCompletoDto peliculaCompletoDto1 = PeliculaCompletoDto.mapToDto(pelicula);
            return ResponseEntity.status(HttpStatus.OK).body(peliculaCompletoDto1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }



}
