package com.example.curso.dao;


import com.example.curso.entity.Servicio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicioDao extends CrudRepository<Servicio, Long> {
    public List<Servicio> findByAfiliacion(Long afiliacion);

    public Servicio findByEmail(String email);

}
