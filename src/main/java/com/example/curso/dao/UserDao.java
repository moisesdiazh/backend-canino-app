package com.example.curso.dao;


import com.example.curso.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {

	public User findByEmail(String email); //colocamos solamente para buscar por Email porque es unico

	public User findByRut(String rut); //colocamos solamente para buscar por Email porque es unico

	public User findByEmailAndPassword(String email, String password);  //buscar por el email y password

	public Optional<User> findById(Long id); //buscar por el id del profesor


	
	
}
