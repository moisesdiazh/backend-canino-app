package com.example.curso.service;

import com.example.curso.dao.UserDao;
import com.example.curso.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public User findUser(User user) {

		return userDao.findByRut(user.getRut());
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {

		return userDao.findById(id).orElse(null);
	}


	@Override
	@Transactional(readOnly = true)
	public User checkUserLogin(User user) {

		return userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());

	}

	@Override
	@Transactional
	public User updateUser(User user) {

		return userDao.save(user);
	}


	@Override
	@Transactional
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(User user) {

		if(userDao.findByRut(user.getRut()) == null && userDao.findByEmail(user.getEmail()) == null){

			user.setRole("user");
			userDao.save(user);
		}
	}

}
