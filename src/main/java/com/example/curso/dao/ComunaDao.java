package com.example.curso.dao;


import com.example.curso.entity.Comuna;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ComunaDao extends CrudRepository<Comuna, Long> {

    public Optional<Comuna> findById(Long usuario);
}
