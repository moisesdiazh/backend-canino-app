package com.example.curso.service;

import com.example.curso.dao.VacunaDao;
import com.example.curso.entity.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class VacunaServiceImpl implements VacunaService {

	@Autowired
	private VacunaDao vacunaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vacuna> findAllVacunas() {
		return (List<Vacuna>) vacunaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vacuna findById(Long id) {

		return vacunaDao.findById(id).orElse(null);
	}

}
