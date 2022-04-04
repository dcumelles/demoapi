package com.example.demo.persistence.entities;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String mensaje;

    @Column
    private Integer alumnoId;

}
