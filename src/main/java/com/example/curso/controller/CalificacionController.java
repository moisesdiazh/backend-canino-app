package com.example.curso.controller;

import com.example.curso.entity.Calificacion;
import com.example.curso.model.CalificacionObject;
import com.example.curso.service.CalificacionService;
import com.example.curso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CalificacionController {
	
	@Autowired
	private CalificacionService calificacionService;

	private UserService userService;


	@PostMapping("/add-calificacion")
	public void addCalificacion (@RequestBody Calificacion calificacion){
		//public ResponseEntity<Void> addCalificacion (@RequestBody Calificacion calificacion){


		//if(userService.findById(calificacion.getUsuario()) != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			calificacion.setCalificacion(calificacion.getCalificacion());
			calificacion.setFechaCalificacion(timestamp);
			calificacion.setCreatedAt(timestamp);
			calificacionService.save(calificacion);
			//return new ResponseEntity<Void> (HttpStatus.CREATED);
		//}else {
		//	return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		//}
	}


	@GetMapping("/total-calificacion/{userId}")
	public CalificacionObject totalCalificacionByUser (@PathVariable Integer userId){

		Integer calificacionDB = calificacionService.getCalificacionesTotal(userId);

		CalificacionObject calificacionTotal = new CalificacionObject();
		calificacionTotal.setCalificacionTotal(calificacionDB);

		return calificacionTotal;
	}


}
