package com.proyectoPeliculas.peliculas.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private String edad;
    @Column(name = "peso")
    private String peso;
    @Column(name = "historia")
    private String historia;

    @JsonIgnore
    @ManyToMany(cascade =  CascadeType.ALL,fetch = FetchType.EAGER )
    @JoinTable(name = "Personaje_Pelicula",
            joinColumns = { @JoinColumn(name = "personaje_id") },
            inverseJoinColumns = { @JoinColumn(name = "pelicula_id") })
    List<Pelicula> peliculas ;




}
