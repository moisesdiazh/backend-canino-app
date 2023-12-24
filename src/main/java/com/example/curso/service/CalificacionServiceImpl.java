package com.example.curso.service;

import com.example.curso.dao.CalificacionDao;
import com.example.curso.entity.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CalificacionServiceImpl implements CalificacionService {

	@Autowired
	private CalificacionDao calificacionDao;


	@Override
	@Transactional(readOnly = true)
	public List<Calificacion> findCalificacionesByUsuario(Calificacion calificacion) {

		return calificacionDao.findByUsuario(calificacion.getUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getCalificacionesTotal(Integer usuario){

		return calificacionDao.getCalificacionesByUser(usuario);
	}


	@Override
	@Transactional
	public void save(Calificacion calificacion) {

		calificacionDao.save(calificacion);
	}

}
