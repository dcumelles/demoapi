package com.example.demo.persistence.repositories;

import com.example.demo.persistence.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    @Query(value = "SELECT * FROM mensajes WHERE id = ?1", nativeQuery = true)
    Mensaje findMensaje(Integer integer);

    @Query(value = "SELECT * FROM mensajes WHERE alumno_id = ?1", nativeQuery = true)
    List<Mensaje> findMensajesFromAlumnoId(Integer id);
}
