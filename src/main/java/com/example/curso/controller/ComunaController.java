package com.example.curso.controller;

import com.example.curso.entity.Comuna;
import com.example.curso.service.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ComunaController {
	
	@Autowired
	private ComunaService comunaService;


	@GetMapping("/comunas")
	@ResponseStatus(HttpStatus.OK)
	public List<Comuna> getComunas(){

		return comunaService.findAllComunas();
	}

	@GetMapping("/comuna-by-id/{id}")
	public Comuna findAfiliacion (@PathVariable(value = "id") Long id){

		return comunaService.findByComunaById(id);
	}





}
