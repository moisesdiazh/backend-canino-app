package com.example.curso.service;

import com.example.curso.entity.Calificacion;

import java.util.List;


public interface CalificacionService {


	public List<Calificacion> findCalificacionesByUsuario(Calificacion calificacion);

	public Integer getCalificacionesTotal(Integer usuario);


	public void save (Calificacion calificacion);

}
