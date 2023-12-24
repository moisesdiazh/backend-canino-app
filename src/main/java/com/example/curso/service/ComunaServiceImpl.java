package com.example.curso.service;

import com.example.curso.dao.ComunaDao;
import com.example.curso.dao.PerroDao;
import com.example.curso.entity.Comuna;
import com.example.curso.entity.Perro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ComunaServiceImpl implements ComunaService {

	@Autowired
	private ComunaDao comunaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Comuna> findAllComunas() {
		return (List<Comuna>) comunaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Comuna findByComunaById(Long id) {

		return comunaDao.findById(id).orElse(null);
	}



}
