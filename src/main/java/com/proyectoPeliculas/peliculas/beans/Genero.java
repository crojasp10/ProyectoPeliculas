package com.proyectoPeliculas.peliculas.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="imagen")
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "genero",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pelicula> peliculas;


}
