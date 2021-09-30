package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.entities.Personaje;
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

    @GetMapping(value = "/character")
    public ResponseEntity<?> obtener_imagen_y_nombre() throws Exception{
        try{
            System.out.println("Por cargar la lista");
            List<Personaje> personajeList = servicio.obtener_imagen_y_nombre();
            System.out.println("Lista cargada");
            return ResponseEntity.status(HttpStatus.OK).body(personajeList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("---  ERROR  --- ");
        }
    }

    @GetMapping(value = "/characters")
    public ResponseEntity<?> busqueda(@RequestParam String filtro){
        try{
            List<Personaje> personajeList = servicio.buscar_personaje(filtro);
            return ResponseEntity.status(HttpStatus.OK).body(personajeList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }

    /*
    @GetMapping(value = "/charactersAvanzada")
    public ResponseEntity<?> busquedaAvanzada(@RequestParam String filtroNombre, @RequestParam int filtroEdad){
        try{
            List<Personaje> personajeList = servicio.buscar_personaje(filtroNombre, filtroEdad);
            return ResponseEntity.status(HttpStatus.OK).body(personajeList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("~~~♀|  ERROR  |♀~~~ ");
        }
    }
*/


}
