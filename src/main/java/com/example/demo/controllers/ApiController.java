package com.example.demo.controllers;

import com.example.demo.persistence.entities.Alumno;
import com.example.demo.persistence.entities.Mensaje;
import com.example.demo.persistence.repositories.AlumnosRepository;
import com.example.demo.persistence.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiController {

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Autowired
    private MensajeRepository mensajeRepository;

    @GetMapping("/alumnos/{id}")
    public Alumno getAlumno(@PathVariable Integer id){
        Alumno alumno = alumnosRepository.findAlumnoById(id);

        return alumno;
    }

    @GetMapping("/alumnos/{id}/anonimo")
    public Alumno getAlumnoAnonimo(@PathVariable Integer id){
        Alumno alumno = alumnosRepository.findAlumnoById(id);
        alumno.setNombre("Anónimo");
        return alumno;
    }

    @GetMapping("/alumnos/{nombre}/id")
    public Integer getIdAlumnoNombre(@PathVariable String nombre){
        Integer id = alumnosRepository.findIdByName(nombre);

        return id;
    }

    @GetMapping("/notfound/{id}")
    public ResponseEntity<?> getAlumnoNotFound(@PathVariable Integer id){
        Alumno alumno = alumnosRepository.findAlumnoById(id);

        return alumno != null ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?> insertAlumno(@RequestBody Alumno alumnoNuevo){
        Alumno alumno = alumnosRepository.save(alumnoNuevo);

        return ResponseEntity.status(HttpStatus.CREATED).body("Alumno creado! ID: " + alumno.getId());
    }

    @GetMapping("/mensajes/{alumnId}")
    public List<Mensaje> getMensajesAlumno(@PathVariable Integer alumnId){
        List<Mensaje> mensajes = mensajeRepository.findMensajesFromAlumnoId(alumnId);

        return mensajes;
    }

    @PostMapping("/mensajes")
    public ResponseEntity<?> insertMensaje(@RequestBody Mensaje mensaje){
        Alumno alumno = alumnosRepository.findAlumnoById(mensaje.getAlumnoId());
        if (alumno != null) {
            mensajeRepository.save(mensaje);
            return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje creado! Gracias, " + alumno.getNombre());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado!");
    }



}
