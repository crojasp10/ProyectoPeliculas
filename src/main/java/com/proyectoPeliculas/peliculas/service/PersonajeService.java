package com.proyectoPeliculas.peliculas.service;

import com.proyectoPeliculas.peliculas.beans.Personaje;
import com.proyectoPeliculas.peliculas.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {


    @Autowired
    private PersonajeRepository personajeRepository;

    public ResponseEntity updatePersonaje(Personaje personaje) {

        ResponseEntity response = null;
        System.out.println("El personaje con id es: " + personaje);
        Personaje personaje1 = personajeRepository.findById(personaje.getId());
        System.out.println("El personaje con id es: " + personaje1);

        if (personajeRepository.findById(personaje.getId()) != null) {
            System.out.println("El paciente es: "+personaje);
            personaje1.setId(personaje.getId());
            System.out.println("Setea el id");
            personaje1.setImagen(personaje.getImagen());
            System.out.println("Setea el la imagen");
            personaje1.setNombre(personaje.getNombre());
            personaje1.setEdad(personaje.getEdad());
            personaje1.setPeso(personaje.getPeso());
            personaje1.setHistoria(personaje.getHistoria());

            System.out.println("Se setea el paciente");

            response = ResponseEntity.ok(personajeRepository.save(personaje1));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return response;
    }



    public ResponseEntity deletePersonajeById(int id) {

        ResponseEntity response = null;
        if(personajeRepository.findById(id)==null){
            response = new ResponseEntity( HttpStatus.NOT_FOUND);
        }else{
            personajeRepository.deleteById(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }








}
