package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.PersonajePelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajePeliculaRepository extends JpaRepository <PersonajePelicula,Integer> {


}
