package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.DTO.PeliculaCompletoDto;
import com.example.alkemy_disney.DTO.PeliculaDto;
import com.example.alkemy_disney.DTO.PeliculaSaveDto;
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

    @GetMapping(value = "/get_all")
    public ResponseEntity<?> getAll() throws Exception{
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

    // PRUEBAS
    @PostMapping(value = "/save_pelicula_dto")
    public ResponseEntity<?> guardar_pelicula_completa_DTO(@RequestBody PeliculaSaveDto peliculaSaveDto) throws Exception{
        try{
            Pelicula pelicula = Pelicula.mapToEntity(peliculaSaveDto);
            this.servicio.save(pelicula);
            PeliculaSaveDto peliculaSaveDto1 = PeliculaSaveDto.mapToDto(pelicula);
            return ResponseEntity.status(HttpStatus.OK).body(peliculaSaveDto1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


    // Pruebas Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity borrar_pelicula(@PathVariable Long id)
    throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    // Get One
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            if (this.servicio.findById(id) != null) {
                Pelicula pelicula = this.servicio.findById(id);
                PeliculaCompletoDto peliculaCompletoDto = PeliculaCompletoDto.mapToDto(pelicula);
                return ResponseEntity.status(HttpStatus.OK).body(peliculaCompletoDto);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Pelicula no encontrada");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }



}
