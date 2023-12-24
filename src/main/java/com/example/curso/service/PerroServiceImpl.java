package com.example.curso.service;

import com.example.curso.dao.PerroDao;
import com.example.curso.entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PerroServiceImpl implements PerroService {

	@Autowired
	private PerroDao perroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Perro> findAllPerros() {
		return (List<Perro>) perroDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Perro findById(Long id) {

		return perroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Perro findPerro(Perro perro) {

		return perroDao.findByChip(perro.getChip());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perro> findPerrosByUser(Long id) {

		return perroDao.findByUsuario(id);
	}

	@Override
	@Transactional
	public Perro updatePerro(Perro perro) {
		return perroDao.save(perro);
	}


	@Override
	@Transactional
	public void deletePerro(Long id) {
		perroDao.deleteById(id);
	}

	@Override
	@Transactional
	public void savePerro(Perro perro) { //guardando el profesor en la bd
		
		perroDao.save(perro);
	}

}
