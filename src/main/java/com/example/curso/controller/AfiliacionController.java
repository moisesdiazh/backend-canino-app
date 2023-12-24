package com.example.curso.controller;

import com.example.curso.entity.Afiliacion;
import com.example.curso.entity.Perro;
import com.example.curso.entity.User;
import com.example.curso.service.AfiliacionService;
import com.example.curso.service.PerroService;
import com.example.curso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AfiliacionController {
	
	@Autowired
	private AfiliacionService afiliacionService;

	@Autowired
	private UserService userService;


	@PostMapping("/add-afiliacion")
	public Afiliacion addAfiliacion (@RequestBody Afiliacion afiliacion){

		Afiliacion afiliacionVacio = new Afiliacion();

		if(afiliacionService.findByUsuario(afiliacion) == null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			afiliacion.setTipoAfiliacion("Premium");
			afiliacion.setActive(true);
			afiliacion.setCreatedAt(timestamp);
			afiliacionService.save(afiliacion);

			return afiliacion;

		}else {

			return afiliacionVacio;
		}
	}

	@GetMapping("/afiliados")
	@ResponseStatus(HttpStatus.OK)
	public List<Afiliacion> getAfiliados(){

		return afiliacionService.findAllAfiliacion();
	}

	@GetMapping("/afiliacion/{id}")
	public Afiliacion findAfiliacion (@PathVariable(value = "id") Long id){

		return afiliacionService.findAfiliacionByUsuario(id);
	}

	@PutMapping("/afiliacion/cancelar")
	public ResponseEntity<?> cancelAfiliacion (@RequestBody Afiliacion afiliacion){


			Afiliacion afiliacionDB = afiliacionService.findByUsuario(afiliacion);
			
			if(afiliacionDB != null) {

				LocalDateTime fechaHoraActual = LocalDateTime.now();

				Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

				afiliacionDB.setTipoAfiliacion("No Premium");
				afiliacionDB.setActive(false);
				afiliacionDB.setUpdatedAt(timestamp);

				afiliacionService.updateAfiliacion(afiliacionDB);

				return new ResponseEntity<> (afiliacionDB, HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

			}
		
	}

	@PutMapping("/afiliacion/renovar")
	public ResponseEntity<?> renovarAfiliacion (@RequestBody Afiliacion afiliacion){

		Afiliacion afiliacionDB = afiliacionService.findByUsuario(afiliacion);

		if(afiliacionDB != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			afiliacionDB.setTipoAfiliacion("Premium");
			afiliacionDB.setActive(true);
			afiliacionDB.setUpdatedAt(timestamp);

			afiliacionService.updateAfiliacion(afiliacionDB);

			return new ResponseEntity<> (afiliacionDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

		}

	}



	@DeleteMapping("/afiliacion/delete/{id}")
	public ResponseEntity<Void> deletePerro(@PathVariable(value = "id") Long id){
		
			afiliacionService.deleteAfiliacion(id);
			return new ResponseEntity<Void> (HttpStatus.OK);
		
	}



}
