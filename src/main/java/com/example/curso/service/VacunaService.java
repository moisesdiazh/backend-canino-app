package com.example.curso.service;

import com.example.curso.entity.Vacuna;


import java.util.List;

public interface VacunaService {

	public List<Vacuna> findAllVacunas();

	public Vacuna findById(Long id);

}
