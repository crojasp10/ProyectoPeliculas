package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.Pelicula;
import com.proyectoPeliculas.peliculas.beans.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository <Pelicula,Integer> {


    Pelicula save(Pelicula pelicula);

    Pelicula findById(int id);



}
