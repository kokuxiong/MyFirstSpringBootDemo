package com.koku.dao;

import org.springframework.stereotype.Repository;

import com.koku.pojo.User;

@Repository
public interface UserDao {
	User findUserByUsername(String username);
	int createUser(User user);
	int updateUser(User user);
	int deleteUserByUsername(String username);
}
