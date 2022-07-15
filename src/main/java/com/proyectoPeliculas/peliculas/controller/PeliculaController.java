package com.proyectoPeliculas.peliculas.controller;

import com.proyectoPeliculas.peliculas.beans.Pelicula;
import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.repository.PeliculaRepository;
import com.proyectoPeliculas.peliculas.repository.PersonajeRepository;
import com.proyectoPeliculas.peliculas.service.PeliculaService;
import com.proyectoPeliculas.peliculas.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST,RequestMethod. PUT })
@RequestMapping("/pelicula")
public class PeliculaController {


    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/newPelicula")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity savePelicula(@RequestBody Pelicula pelicula) {

        return ResponseEntity.ok(peliculaService.savePelicula(pelicula));

    }


    @GetMapping("/getPeliculas")
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        return ResponseEntity.ok(peliculaRepository.findAll());

    }


    @PutMapping("/updatePelicula")
    public ResponseEntity updatePelicula( @RequestBody Pelicula pelicula){
        System.out.println("Se recibe el personaje"+pelicula);
        return peliculaService.updatePelicula(pelicula);
    }

    @DeleteMapping("/deletePelicula/{id}")
    public ResponseEntity deletePeliculaById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el Pelicula");
        return peliculaService.deletePeliculaById(id);
    }











}
