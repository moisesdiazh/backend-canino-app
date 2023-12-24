package com.example.curso.dao;


import com.example.curso.entity.Calificacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalificacionDao extends CrudRepository<Calificacion, Long> {

    public List<Calificacion> findByUsuario(Integer usuario);

    @Query("SELECT SUM(c.calificacion) FROM Calificacion c WHERE c.usuario = ?1")
    public Integer getCalificacionesByUser(Integer usuario);
}
