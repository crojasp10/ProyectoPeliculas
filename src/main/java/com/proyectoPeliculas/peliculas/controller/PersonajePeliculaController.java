package com.proyectoPeliculas.peliculas.controller;

import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.beans.PersonajePelicula;
import com.proyectoPeliculas.peliculas.repository.PersonajePeliculaRepository;
import com.proyectoPeliculas.peliculas.service.PersonaPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST,RequestMethod. PUT })
@RequestMapping("/personajePelicula")
public class PersonajePeliculaController {

    @Autowired
    PersonajePeliculaRepository personajePeliculaRepository;
    @Autowired
    PersonaPeliculaService personajePeliculaService;

    @PostMapping("/newPersonajePelicula")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity insertarPersonajePelicula(@RequestBody PersonajePelicula personajePelicula) {

        return ResponseEntity.ok(personajePeliculaService.insertarPersonaPelicula(personajePelicula));

    }






}
