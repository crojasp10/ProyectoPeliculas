package com.proyectoPeliculas.peliculas.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pelicula")
public class Pelicula {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="imagen")
    private String imagen;
    @Column(name="titulo")
    private String titulo;
    @Column(name="fechaDeCreacion")
    private String fechaDeCreacion;
    @Column(name="calificacion")
    private String calificacion;



    @ManyToOne(  fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "genero_id",referencedColumnName = "id")
    private Genero genero;

/*
    @JsonIgnore
    @OneToMany (mappedBy = "pelicula",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PersonajePelicula> personajesPelicula;
*/





}
