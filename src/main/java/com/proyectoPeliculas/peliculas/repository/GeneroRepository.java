package com.proyectoPeliculas.peliculas.repository;

import com.proyectoPeliculas.peliculas.beans.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository <Genero, Integer> {
}
