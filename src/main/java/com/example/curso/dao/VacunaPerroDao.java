package com.example.curso.dao;


import com.example.curso.entity.VacunaPerro;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VacunaPerroDao extends CrudRepository<VacunaPerro, Long> {

    public List<VacunaPerro> findByPerro(Long perro);

    public VacunaPerro findByVacuna(Long vacuna);

}
