package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.DTO.GeneroDto;
import com.example.alkemy_disney.DTO.GeneroSaveDto;
import com.example.alkemy_disney.DTO.PeliculaDto;
import com.example.alkemy_disney.DTO.PersonajeCompletoDto;
import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.entities.Pelicula;
import com.example.alkemy_disney.entities.Personaje;
import com.example.alkemy_disney.services.GeneroServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/generos")
public class GeneroController extends BaseControllerImpl<Genero, GeneroServiceImpl> {

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GeneroSaveDto generoDto){
        try{
            Genero genero = Genero.mapToEntity(generoDto);
            GeneroSaveDto generoDto1 = GeneroSaveDto.mapToDto(this.servicio.save(genero));
            return ResponseEntity.status(HttpStatus.OK).body(generoDto1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> obtener_generos_completo() throws Exception{
        try{
            List<Genero> generoList = servicio.findAll();
            List<GeneroDto> generoDtoList = GeneroDto.mapToDtoList(generoList);
            return ResponseEntity.status(HttpStatus.OK).body(generoDtoList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


}
