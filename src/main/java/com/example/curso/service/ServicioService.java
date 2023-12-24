package com.example.curso.service;


import com.example.curso.entity.Afiliacion;
import com.example.curso.entity.Servicio;
import com.example.curso.entity.User;

import java.util.List;


public interface ServicioService {

	public List<Servicio> findAllServicios();

	public List<Servicio> findServicioByAfiliacion(Long id);

	public Servicio findServicio(Servicio servicio);

	public Servicio findServicioById(Long id);

	public Servicio updateServicio(Servicio servicio);

	public void deleteServicio(Long id);

	public void save (Servicio servicio);

}
