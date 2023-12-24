package com.example.curso.controller;


import com.example.curso.entity.Vacuna;
import com.example.curso.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class VacunaController {
	
	@Autowired
	private VacunaService vacunaService;


	@GetMapping("/vacunas")
	@ResponseStatus(HttpStatus.OK)
	public List<Vacuna> getVacunas(){

		return vacunaService.findAllVacunas();
	}

	@GetMapping("/vacuna/{id}")
	public Vacuna findVacunaById (@PathVariable(value = "id") Long id){

		return vacunaService.findById(id);
	}


}
