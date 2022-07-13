package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository  extends JpaRepository <Personaje, Integer> {


    Personaje findById(int id);
}
