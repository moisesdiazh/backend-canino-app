package com.example.curso.controller;

import com.example.curso.entity.User;
import com.example.curso.mapper.Mapper;
import com.example.curso.model.UserObject;
import com.example.curso.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser (@RequestBody User user){

		if(userService.findUser(user) == null) {

			LocalDateTime fechaHoraActual = LocalDateTime.now();

			Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

			user.setCreatedAt(timestamp);
			userService.save(user);
			return new ResponseEntity<Void> (HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		
		return userService.findAll();
	}

	@PostMapping("/find-user")
	public ResponseEntity<?> findUser (@RequestBody User user){

		User userDB = null;

		userDB = userService.findUser(user);
		
		if(userDB != null) {
			return new ResponseEntity<> (userDB, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody User user){
		
		User userDB = userService.checkUserLogin(user);
		
		if(userDB != null) {
			
			List<User> users = new ArrayList<>();
			users.add(userDB);
			
			List<UserObject> userObjectList;

			userObjectList = Mapper.convertList(users);
			
			return new ResponseEntity<> (userObjectList, HttpStatus.OK);

		} else {
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
		}
	}


	@PutMapping("/edit-user/{id}")
	public ResponseEntity<?> updateUser (@PathVariable(value = "id") Long id, @RequestBody User user){

			User userDB = null;

			userDB = userService.findById(id);
			
			if(userDB != null) {

				LocalDateTime fechaHoraActual = LocalDateTime.now();

				Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);

				user.setUpdatedAt(timestamp);

				BeanUtils.copyProperties(user, userDB, getNullPropertyNames(user));

				userService.updateUser(userDB);

				return new ResponseEntity<> (userDB, HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND);
			}
	}


	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id){
		
			userService.deleteUser(id);
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
