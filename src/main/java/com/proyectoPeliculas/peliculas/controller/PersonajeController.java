package com.proyectoPeliculas.peliculas.controller;

import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.repository.PeliculaRepository;
import com.proyectoPeliculas.peliculas.repository.PersonajeRepository;
import com.proyectoPeliculas.peliculas.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ( origins = "*" , methods= { RequestMethod. GET ,RequestMethod. POST,RequestMethod. PUT })
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PersonajeService personajeService;

    @PostMapping("/newPersonaje")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Personaje> insertarPersonaje(@RequestBody Personaje personaje) {

        return ResponseEntity.ok(personajeRepository.save(personaje));

    }


    @GetMapping("/getPersonajes")
    public ResponseEntity<List<Personaje>> listarPersonajes() {
        return ResponseEntity.ok(personajeRepository.findAll());

    }


    @PutMapping("/updatePersonaje")
    public ResponseEntity updatePersonaje( @RequestBody Personaje personaje){
        System.out.println("Se recibe el personaje"+personaje);
        return personajeService.updatePersonaje(personaje);
    }

    @DeleteMapping("/deletePersonaje/{id}")
    public ResponseEntity deletePersonajeById(@PathVariable (value = "id") int id) {
        System.out.println("Se elimina el Personaje");
        return personajeService.deletePersonajeById(id);
    }


}
