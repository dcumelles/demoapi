package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {
    @Query(value = "SELECT * FROM alumnos WHERE id = ?1", nativeQuery = true)
    Alumno findAlumnoById(Integer id);

    @Query(value = "SELECT id FROM alumnos WHERE nombre = ?1", nativeQuery = true)
    Integer findIdByName(String nombre);
}
