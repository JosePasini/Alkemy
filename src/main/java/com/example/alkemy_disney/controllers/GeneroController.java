package com.example.alkemy_disney.controllers;

import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.services.GeneroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/generos")
public class GeneroController extends BaseControllerImpl<Genero, GeneroServiceImpl> {


}
