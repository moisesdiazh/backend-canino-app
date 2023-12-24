package com.example.curso.controller;

import com.example.curso.entity.User;
import com.example.curso.entity.VacunaPerro;
import com.example.curso.service.PerroService;
import com.example.curso.service.VacunaPerroService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class VacunaPerroController {
	
	@Autowired
	private VacunaPerroService vacunaPerroService;

	@Autowired
	private PerroService perroService;


	@PostMapping("/add-vacuna-perro")
	public ResponseEntity<Void> addVacunaPerro(@RequestBody List<VacunaPerro> vacunasPerro) {
		for (VacunaPerro vacunaPerro : vacunasPerro) {
			if (vacunaPerroService.findVacunaPerro(vacunaPerro) == null && perroService.findById(vacunaPerro.getPerro()) != null) {
				LocalDateTime fechaHoraActual = LocalDateTime.now();
				Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);
				vacunaPerro.setCreatedAt(timestamp);
				vacunaPerroService.save(vacunaPerro);
			} else {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/vacunas-perro/{id}")
	public List<VacunaPerro> findVacunasByPerro (@PathVariable(value = "id") Long id){

		return vacunaPerroService.findVacunasByPerro(id);
	}

	@GetMapping("/vacuna-perro/find/{id}")
	public ResponseEntity<?> findPerroVacuna (@PathVariable(value = "id") Long id){

		VacunaPerro vacunaPerroDB = vacunaPerroService.findById(id);

		if(vacunaPerroDB != null) {
			return new ResponseEntity<> (vacunaPerroDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/vacuna-perro/edit/{id}")
	public ResponseEntity<?> updateVacunaPerro (@PathVariable(value = "id") Long id, @RequestBody VacunaPerro vacunaPerro){

		VacunaPerro vacunaPerroDB = vacunaPerroService.findById(id);

		if(vacunaPerroDB != null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			vacunaPerroDB.setVacuna(vacunaPerro.getVacuna());
			vacunaPerroDB.setFechaVacuna(vacunaPerro.getFechaVacuna());
			vacunaPerroDB.setUpdatedAt(timestamp);

			vacunaPerroService.updateVacunaPerro(vacunaPerroDB);

			return new ResponseEntity<> (vacunaPerroDB, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/vacuna-perro/delete/{id}")
	public ResponseEntity<Void> deleteVacunaPerro(@PathVariable(value = "id") Long id){

		vacunaPerroService.deleteVacunaPerro(id);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

	private String[] getNullPropertyNames(User source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<>();
		for (java.beans.PropertyDescriptor pd : pds) {
			// Verifica si el valor de la propiedad es nulo
			if (src.getPropertyValue(pd.getName()) == null) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}


}
