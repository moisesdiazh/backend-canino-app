package com.example.curso.mapper;
import com.example.curso.entity.User;
import com.example.curso.model.UserObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mapper")
public class Mapper {


	public static List<UserObject> convertList(List<User> users){
		List<UserObject> userList = new ArrayList<>(); //definimos mTeachers como un nuevo array vacio
		
		for(User user: users) {
			
			userList.add(new UserObject(user));
			
		}
		return userList;
			
			
	}


}
