package com.example.curso.service;

import com.example.curso.entity.Afiliacion;
import com.example.curso.entity.Perro;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AfiliacionService {

	public List<Afiliacion> findAllAfiliacion();

	public Afiliacion findByUsuario(Afiliacion afiliacion);

	public Afiliacion findAfiliacionByUsuario(Long id);

	public Afiliacion findAfiliacionById(Long id);

	public Afiliacion updateAfiliacion(Afiliacion afiliacion);

	public void deleteAfiliacion(Long id);

	public void save (Afiliacion afiliacion);

}
