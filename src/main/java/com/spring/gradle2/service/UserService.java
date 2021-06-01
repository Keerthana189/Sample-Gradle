package com.spring.gradle2.service;

import java.util.List;

import com.spring.gradle2.entity.Users;

public interface UserService {
	public List<Users> getAllUsers();
	public Users getUserById(int id);
	public Users addOrUpdateUser(Users user);
	public Users deleteUser(int id) throws Exception;

}
