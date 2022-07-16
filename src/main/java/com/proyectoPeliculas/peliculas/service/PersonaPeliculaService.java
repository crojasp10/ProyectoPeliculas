package com.proyectoPeliculas.peliculas.service;

import com.proyectoPeliculas.peliculas.beans.Genero;
import com.proyectoPeliculas.peliculas.beans.Pelicula;
import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.beans.PersonajePelicula;
import com.proyectoPeliculas.peliculas.repository.GeneroRepository;
import com.proyectoPeliculas.peliculas.repository.PeliculaRepository;
import com.proyectoPeliculas.peliculas.repository.PersonajePeliculaRepository;
import com.proyectoPeliculas.peliculas.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaPeliculaService {


    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PersonajePeliculaRepository personajePeliculaRepository;

    @Autowired
    GeneroRepository generoRepository;


    public ResponseEntity insertarPersonaPelicula (PersonajePelicula personajePelicula) {
        ResponseEntity response = null;

        System.out.println("Se muestra el personajePelicula");
        System.out.println(personajePelicula);
        //System.out.println("id paciente turno: "+ turno.getPaciente());


        if (personajeRepository.findById(personajePelicula.getPersonaje().getId()) != null &&
                peliculaRepository.findById((personajePelicula.getPelicula().getId())) != null) {
            Personaje personaje = personajeRepository.findById(personajePelicula.getPersonaje().getId());
            System.out.println("El personaje es  : "+ personaje);

          //  System.out.println("LA PELICULA ES" + pelicula);

            Pelicula pelicula = personajePelicula.getPelicula();

            if(personajePelicula.getPelicula().getGenero()!= null){
                System.out.println("SE SETEA EL GENERO DE PELICULA");
               Genero genero = generoRepository.findById(personajePelicula.getPelicula().getGenero().getId());
               pelicula.setGenero(genero);

            }else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            System.out.println("SE SETEA LA PELICULA");
            personajePelicula.setPelicula(pelicula);
            personajePelicula.setPersonaje(personaje);

            response = ResponseEntity.ok(personajePeliculaRepository.save(personajePelicula));

        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }



















}
