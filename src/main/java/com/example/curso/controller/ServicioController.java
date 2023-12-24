package com.example.curso.controller;

import com.example.curso.entity.Afiliacion;
import com.example.curso.entity.Servicio;
import com.example.curso.service.AfiliacionService;
import com.example.curso.service.ServicioService;
import com.example.curso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;

	@Autowired
	private UserService userService;


	@PostMapping("/add-servicio")
	public ResponseEntity<Void> addServicio (@RequestBody Servicio servicio){

		if(servicioService.findServicio(servicio) == null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			servicio.setEstado("A");
			servicio.setFechaSolicitud(timestamp);
			servicio.setCreatedAt(timestamp);

			servicioService.save(servicio);
			return new ResponseEntity<Void> (HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/servicios")
	@ResponseStatus(HttpStatus.OK)
	public List<Servicio> getServicios(){

		return servicioService.findAllServicios();
	}

	@GetMapping("/servicio/{id}")
	public Servicio findServicio (@PathVariable(value = "id") Long id){

		return servicioService.findServicioById(id);
	}

	@GetMapping("/servicio/afiliacion/{id}")
	public List<Servicio> findByAfiliacion (@PathVariable(value = "id") Long id){

		return servicioService.findServicioByAfiliacion(id);
	}


	@PutMapping("/servicio/edit/{id}")
	public ResponseEntity<?> updateServicio (@PathVariable(value = "id") Long id, @RequestBody Servicio servicio){

		Servicio servicioDB = servicioService.findServicioById(id);

		if(servicioDB != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			servicioDB.setComuna(servicio.getComuna());
			servicioDB.setNombreServicio(servicio.getNombreServicio());
			servicioDB.setTelefono(servicio.getTelefono());
			servicioDB.setEmail(servicio.getEmail());
			servicioDB.setDireccion(servicio.getDireccion());
			servicioDB.setEstado("A");
			servicioDB.setUpdatedAt(timestamp);

			servicioService.updateServicio(servicioDB);

			return new ResponseEntity<> (servicioDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping("/servicio/bajar/{id}")
	public ResponseEntity<?> bajarServicio (@PathVariable(value = "id") Long id){

		Servicio servicioDB = servicioService.findServicioById(id);

		if(servicioDB != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			servicioDB.setEstado("N");
			servicioDB.setUpdatedAt(timestamp);

			servicioService.updateServicio(servicioDB);

			return new ResponseEntity<> (servicioDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

		}
	}

	@PutMapping("/servicio/subir/{id}")
	public ResponseEntity<?> subirServicio (@PathVariable(value = "id") Long id){

		Servicio servicioDB = servicioService.findServicioById(id);

		if(servicioDB != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			servicioDB.setEstado("A");
			servicioDB.setUpdatedAt(timestamp);

			servicioService.updateServicio(servicioDB);

			return new ResponseEntity<> (servicioDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("/servicio/delete/{id}")
	public ResponseEntity<Void> deleteServicio(@PathVariable(value = "id") Long id){
		
			servicioService.deleteServicio(id);
			return new ResponseEntity<Void> (HttpStatus.OK);
	}


}
