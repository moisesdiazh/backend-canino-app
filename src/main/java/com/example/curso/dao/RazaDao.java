package com.example.curso.dao;

import com.example.curso.entity.Raza;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RazaDao extends CrudRepository<Raza, Long> {

    public Optional<Raza> findById(Long raza);
}
