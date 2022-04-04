package com.example.demo.persistence.entities;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String ciclo;

}
