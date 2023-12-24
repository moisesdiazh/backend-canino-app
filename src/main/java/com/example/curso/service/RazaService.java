package com.example.curso.service;

import com.example.curso.entity.Comuna;
import com.example.curso.entity.Raza;

import java.util.List;


public interface RazaService {
	public List<Raza> findAllRazas();

	public Raza findByRazaById(Long id);
}
