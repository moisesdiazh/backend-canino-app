package com.example.curso.service;

import com.example.curso.dao.RazaDao;
import com.example.curso.entity.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RazaServiceImpl implements RazaService {

	@Autowired
	private RazaDao razaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Raza> findAllRazas() {
		return (List<Raza>) razaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Raza findByRazaById(Long id) {

		return razaDao.findById(id).orElse(null);
	}



}
