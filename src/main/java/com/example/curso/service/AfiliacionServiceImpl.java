package com.example.curso.service;

import com.example.curso.dao.AfiliacionDao;
import com.example.curso.entity.Afiliacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AfiliacionServiceImpl implements AfiliacionService {

	@Autowired
	private AfiliacionDao afiliacionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Afiliacion> findAllAfiliacion() {
		return (List<Afiliacion>) afiliacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Afiliacion findByUsuario(Afiliacion afiliacion) {

		return afiliacionDao.findByUsuario(afiliacion.getUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Afiliacion findAfiliacionById(Long id){

		return afiliacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Afiliacion findAfiliacionByUsuario(Long id) {

		return afiliacionDao.findByUsuario(id);
	}

	@Override
	@Transactional
	public Afiliacion updateAfiliacion(Afiliacion afiliacion) {

		if(afiliacionDao.findByUsuario(afiliacion.getUsuario()) != null) {
			afiliacionDao.save(afiliacion);
		}

		return afiliacion;
	}

	@Override
	@Transactional
	public void deleteAfiliacion(Long id) {

		if(afiliacionDao.findById(id) != null) {
			afiliacionDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void save(Afiliacion afiliacion) {

		if(afiliacionDao.findByUsuario(afiliacion.getUsuario()) == null){

			afiliacionDao.save(afiliacion);
		}
	}

}
