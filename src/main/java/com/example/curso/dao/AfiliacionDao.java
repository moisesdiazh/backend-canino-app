package com.example.curso.dao;


import com.example.curso.entity.Afiliacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AfiliacionDao extends CrudRepository<Afiliacion, Long> {
    public Afiliacion findByUsuario(Long usuario);
}
