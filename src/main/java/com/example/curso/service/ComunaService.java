package com.example.curso.service;

import com.example.curso.entity.Comuna;

import java.util.List;


public interface ComunaService {

	public List<Comuna> findAllComunas();

	public Comuna findByComunaById(Long id);


}
