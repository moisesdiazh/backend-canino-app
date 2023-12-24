package com.example.curso.service;

import com.example.curso.dao.ServicioDao;
import com.example.curso.entity.Servicio;
import com.example.curso.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioDao servicioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAllServicios() {
		return (List<Servicio>) servicioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findServicioByAfiliacion(Long id) {

		return servicioDao.findByAfiliacion(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio findServicio(Servicio servicio) {

		return servicioDao.findByEmail(servicio.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio findServicioById(Long id){

		return servicioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Servicio updateServicio(Servicio servicio) {

		if(servicioDao.findByEmail(servicio.getEmail()) != null) {
			servicioDao.save(servicio);
		}

		return servicio;
	}

	@Override
	@Transactional
	public void deleteServicio(Long id) {

		if(servicioDao.findById(id) != null) {
			servicioDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void save(Servicio servicio) {

		if(servicioDao.findByEmail(servicio.getEmail()) == null){

			servicioDao.save(servicio);
		}
	}

}
