package com.example.curso.dao;


import com.example.curso.entity.Perro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerroDao extends CrudRepository<Perro, Long> {

	public Perro findByChip(String chip);
    public List<Perro> findByUsuario(Long usuario);
}
