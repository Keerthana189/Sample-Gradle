package com.spring.gradle2.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle2.entity.Users;
import com.spring.gradle2.repository.UserRepository;
import com.spring.gradle2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private Users user;
	
	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public Users getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Users addOrUpdateUser(Users user) {
		//Users u=null;
		user.setName(user.getName());
		user.setAge(user.getAge());
		user.setSalary(user.getSalary());
		return userRepository.save(user);
	}

	@Override
	public Users deleteUser(int id) throws Exception {
		Users delUser=null;
		try {
			delUser=userRepository.findById(id).orElse(null);
			if(delUser==null) {
				throw new Exception("User not available");
			}
			else {
				userRepository.deleteById(id);
			}
		}
		catch(Exception e) {
		    throw e;	
		}
		return delUser;
	}

}
