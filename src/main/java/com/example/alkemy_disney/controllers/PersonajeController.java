package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.DTO.GeneroDto;
import com.example.alkemy_disney.DTO.PersonajeCompletoDto;
import com.example.alkemy_disney.DTO.PersonajeDto;
import com.example.alkemy_disney.entities.Personaje;
import com.example.alkemy_disney.services.GeneroServiceImpl;
import com.example.alkemy_disney.services.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/personajes")
public class PersonajeController extends BaseControllerImpl<Personaje, PersonajeServiceImpl> {


    @Autowired
    private GeneroServiceImpl generoService;



    @GetMapping(value = "/characters")
    public ResponseEntity<?> busqueda(){
        try{
            List<Personaje> personajeList = servicio.buscar_personaje();
            List<PersonajeDto> personajeDtoList = PersonajeDto.mapToDtoList(personajeList);
            return ResponseEntity.status(HttpStatus.OK).body(personajeDtoList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }

    @GetMapping(value = "/view_all")
    public ResponseEntity<?> view_personajes(){
        try{
            List<Personaje> personajeList = servicio.buscar_personajes_completos();
            List<PersonajeCompletoDto> personajeCompletoDtos = PersonajeCompletoDto.mapToDtoList(personajeList);
            return ResponseEntity.status(HttpStatus.OK).body(personajeCompletoDtos);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            if (this.servicio.findById(id) != null){
                Personaje personaje = this.servicio.findById(id);
                PersonajeCompletoDto personajeCompletoDto = PersonajeCompletoDto.mapToDto(personaje);
                return ResponseEntity.status(HttpStatus.OK).body(personajeCompletoDto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  Personaje no encontrado  |♀~~~ ");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }



}
