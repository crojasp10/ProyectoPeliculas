package com.proyectoPeliculas.peliculas.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "personajePelicula")
public class PersonajePelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name= "id")
    private int id;

    @ManyToOne(  fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "personaje_id",referencedColumnName = "id")
    private Personaje personaje;

    @ManyToOne( fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "pelicula_id",referencedColumnName = "id")
    private Pelicula pelicula;


}
