package com.koku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koku.dao.UserDaoImpl;
import com.koku.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public User findUserByUsername(String username) {
		return userDaoImpl.findUserByUsername(username);
	}
	public int createUser(User user) {
		return userDaoImpl.createUser(user);
	}
	public int updateUser(User user) {
		return userDaoImpl.updateUser(user);
	}
	public int deleteUserByUsername(String username) {
		return userDaoImpl.deleteUserByUsername(username);
	}
}
