package com.example.curso.service;

import com.example.curso.dao.VacunaPerroDao;
import com.example.curso.entity.VacunaPerro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class VacunaPerroServiceImpl implements VacunaPerroService {

	@Autowired
	private VacunaPerroDao vacunaPerroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<VacunaPerro> findVacunasByPerro(Long perro) {
		return (List<VacunaPerro>) vacunaPerroDao.findByPerro(perro);
	}

	@Override
	@Transactional(readOnly = true)
	public VacunaPerro findVacunaPerro(VacunaPerro vacunaPerro){

		return vacunaPerroDao.findByVacuna(vacunaPerro.getVacuna());

	}


	@Override
	@Transactional(readOnly = true)
	public VacunaPerro findById(Long id) {

		return vacunaPerroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public VacunaPerro updateVacunaPerro(VacunaPerro vacunaPerro) {

		if(vacunaPerroDao.findByVacuna(vacunaPerro.getVacuna()) != null) {
			vacunaPerroDao.save(vacunaPerro);
		}

		return vacunaPerro;
	}

	@Override
	@Transactional
	public void deleteVacunaPerro(Long id) {

		if(vacunaPerroDao.findById(id) != null) {
			vacunaPerroDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void save(VacunaPerro vacunaPerro) {

		if(vacunaPerroDao.findByVacuna(vacunaPerro.getVacuna()) == null){

			vacunaPerroDao.save(vacunaPerro);
		}
	}

}
