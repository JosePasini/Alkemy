package com.example.alkemy_disney.services;

import com.example.alkemy_disney.DTO.GeneroDto;
import com.example.alkemy_disney.entities.Genero;

public interface GeneroService extends BaseService<Genero, Long>{
    Genero saveDto(GeneroDto generoDto) throws Exception;
}
