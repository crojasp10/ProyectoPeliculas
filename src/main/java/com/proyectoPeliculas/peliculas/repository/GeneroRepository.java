package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.Genero;
import com.proyectoPeliculas.peliculas.beans.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository <Genero, Integer> {


    Genero findById(int id);


}
