package com.proyectoPeliculas.peliculas.service;


import com.proyectoPeliculas.peliculas.beans.Genero;
import com.proyectoPeliculas.peliculas.beans.Pelicula;
import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.repository.GeneroRepository;
import com.proyectoPeliculas.peliculas.repository.PeliculaRepository;
import com.proyectoPeliculas.peliculas.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {


    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    public ResponseEntity updatePelicula(Pelicula pelicula) {

        ResponseEntity response = null;
        System.out.println("El pelicula con id es: " + pelicula);
        Pelicula pelicula1 = peliculaRepository.findById(pelicula.getId());
        System.out.println("El pelicula con id es: " + pelicula1);

        if (peliculaRepository.findById(pelicula.getId()) != null) {
            System.out.println("la pelicula es: " + pelicula);
            pelicula1.setId(pelicula.getId());
            System.out.println("Setea el id");
            pelicula1.setImagen(pelicula.getImagen());
            System.out.println("Setea el la imagen");
            pelicula1.setTitulo(pelicula.getTitulo());
            pelicula1.setFechaDeCreacion(pelicula.getFechaDeCreacion());
            pelicula1.setCalificacion(pelicula.getCalificacion());
            pelicula1.setGenero(pelicula.getGenero());

            System.out.println("Se setea la pelicula");

            response = ResponseEntity.ok(peliculaRepository.save(pelicula1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return response;
    }


    public ResponseEntity deletePeliculaById(int id) {

        ResponseEntity response = null;
        if (peliculaRepository.findById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            peliculaRepository.deleteById(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    public ResponseEntity savePelicula(Pelicula pelicula) {

        ResponseEntity response = null;

        Pelicula pelicula1 = pelicula;
        List<Personaje> personajeList = new ArrayList<>();

        System.out.println("LA PELICULA ES " + pelicula1);
        Genero genero1 = generoRepository.findById(pelicula.getGenero().getId());
        System.out.println("ELGENERO ES" + genero1);
        if (generoRepository.findById(pelicula.getGenero().getId()) != null) {
            System.out.println("la pelicula es: " + pelicula);
            pelicula1.setId(pelicula.getId());
            System.out.println("Setea el id");
            pelicula1.setImagen(pelicula.getImagen());
            System.out.println("Setea el la imagen");
            pelicula1.setTitulo(pelicula.getTitulo());
            pelicula1.setFechaDeCreacion(pelicula.getFechaDeCreacion());
            pelicula1.setCalificacion(pelicula.getCalificacion());
            pelicula1.setGenero(genero1);

/*
        for (int i = 0; i < pelicula.getPersonajes().size(); i++) {
            Personaje personajeAgregar = new Personaje();
            personajeAgregar = pelicula.getPersonajes().get(i);
            System.out.println("EL PERSONAJE QUE SE AGREGA ES " + pelicula.getPersonajes().get(i));
            personajeList.add(personajeAgregar);

        }
        System.out.println("SE SETEA LA LISTA " + personajeList);
        pelicula1.setPersonajes(personajeList);
        System.out.println("Se setea el paciente");

 */
        response = ResponseEntity.ok(peliculaRepository.save(pelicula1));
    }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return response;
    }




















}
