package com.example.curso.service;

import com.example.curso.entity.VacunaPerro;

import java.util.List;

public interface VacunaPerroService {

	public List<VacunaPerro> findVacunasByPerro(Long perro);

	public VacunaPerro findVacunaPerro(VacunaPerro vacunaPerro);

	public VacunaPerro findById(Long id);

	public VacunaPerro updateVacunaPerro(VacunaPerro vacunaPerro);

	public void deleteVacunaPerro(Long id);

	public void save (VacunaPerro vacunaPerro);

}
