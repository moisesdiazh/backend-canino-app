package com.example.curso.controller;

import com.example.curso.entity.Raza;
import com.example.curso.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RazaController {
	
	@Autowired
	private RazaService razaService;


	@GetMapping("/razas")
	@ResponseStatus(HttpStatus.OK)
	public List<Raza> getComunas(){

		return razaService.findAllRazas();
	}

	@GetMapping("/raza-by-id/{id}")
	public Raza findAfiliacion (@PathVariable(value = "id") Long id){

		return razaService.findByRazaById(id);
	}

}
