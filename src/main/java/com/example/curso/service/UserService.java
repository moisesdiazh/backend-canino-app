package com.example.curso.service;

import com.example.curso.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();
	
	public User findUser(User user);

	public User findById(Long id);

	public User checkUserLogin(User user);

	public User updateUser(User user);
	public void deleteUser(Long id);

	public void save (User user);


}
