package com.example.curso.service;

import com.example.curso.entity.Perro;

import java.util.List;

public interface PerroService {
	
	//donde colocamos los metodos, estos que definimos en el el DAO

	public List<Perro> findAllPerros();

	public Perro findById(Long id);
	
	public Perro findPerro(Perro perro);

	public List<Perro> findPerrosByUser(Long id);

	public Perro updatePerro(Perro perro);

	public void deletePerro(Long id);

	public void savePerro (Perro Perro);


}
