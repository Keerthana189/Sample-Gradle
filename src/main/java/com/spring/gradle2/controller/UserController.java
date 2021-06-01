package com.spring.gradle2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle2.entity.Users;
import com.spring.gradle2.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	 
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> users=null;
		try {
		    users=userService.getAllUsers();	
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable("id") int id){
		Users users=null;
		try {
		    users=userService.getUserById(id);	
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	@PutMapping("au")
	public ResponseEntity<Users> addOrUpdate(@RequestBody Users user){
		Users users=null;
		try {
		    users=userService.addOrUpdateUser(users);	
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	@DeleteMapping("del/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable("id") int id){
		Users users=null;
		try {
		    users=userService.deleteUser(id);	
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
}
