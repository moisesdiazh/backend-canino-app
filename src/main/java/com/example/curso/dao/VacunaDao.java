package com.example.curso.dao;


import com.example.curso.entity.Vacuna;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VacunaDao extends CrudRepository<Vacuna, Long> {

    public Optional<Vacuna> findById(Long id);
}
