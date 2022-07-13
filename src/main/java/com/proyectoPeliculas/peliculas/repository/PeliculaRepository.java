package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository <Pelicula,Integer> {
}
