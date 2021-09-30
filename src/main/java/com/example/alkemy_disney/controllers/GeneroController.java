package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.DTO.GeneroDto;
import com.example.alkemy_disney.DTO.PeliculaDto;
import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.entities.Pelicula;
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

    @PostMapping(path = "/guardarDto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardarDto(@RequestBody GeneroDto generoDto){
        try{
            System.out.println("Entro al método");
            Genero genero = servicio.mapToEntity(generoDto);
            genero = servicio.saveDto(generoDto);
            GeneroDto generoDto1 = servicio.mapToDto(genero);
            System.out.println("Salgo del método");
            return ResponseEntity.status(HttpStatus.OK).body(generoDto1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }

    @GetMapping(value = "/view_all")
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
