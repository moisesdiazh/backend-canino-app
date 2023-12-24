package com.example.curso.controller;

import com.example.curso.entity.Perro;
import com.example.curso.entity.User;
import com.example.curso.service.PerroService;
import com.example.curso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PerroController {
	
	@Autowired
	private PerroService perroService;

	@Autowired
	private UserService userService;


	@PostMapping("/add-perro")
	public ResponseEntity<Void> registerPerro (@RequestBody Perro perro){


		if(perroService.findPerro(perro) == null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			perro.setCreatedAt(timestamp);
			perroService.savePerro(perro);
			return new ResponseEntity<Void> (HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/perros")
	@ResponseStatus(HttpStatus.OK)
	public List<Perro> getPerros(){

		return perroService.findAllPerros();
	}

	@GetMapping("/perros-user/{id}")
	public List<Perro> findPerrosByUser (@PathVariable(value = "id") Long id){

		User userDB = userService.findById(id);
		List<Perro> perroDB = new ArrayList<>();

		if(userDB != null) {
			perroDB = perroService.findPerrosByUser(userDB.getId());

		}
		return perroDB;
	}

	@GetMapping("/perro/{id}")
	public Perro findPerros (@PathVariable(value = "id") Long id){

		return perroService.findById(id);
	}

	@PutMapping("/editar-perro/{id}")
	public ResponseEntity<?> updatePerro (@PathVariable(value = "id") Long id, @RequestBody Perro perro){

			Perro perroDB = null;

			perroDB = perroService.findById(id);
			
			if(perroDB != null) {

				LocalDateTime fechaHoraActual = LocalDateTime.now();

				Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

				perroDB.setRaza(perro.getRaza());
				perroDB.setNombreCanino(perro.getNombreCanino());
				perroDB.setEdad(perro.getEdad());
				perroDB.setChip(perro.getChip());
				perroDB.setUpdatedAt(timestamp);

				perroService.updatePerro(perroDB);

				return new ResponseEntity<> (perroDB, HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

			}
		
	}



	@DeleteMapping("/eliminar-perro/{id}")
	public ResponseEntity<Void> deletePerro(@PathVariable(value = "id") Long id){
		
			perroService.deletePerro(id);
			return new ResponseEntity<Void> (HttpStatus.OK);
		
	}



}
