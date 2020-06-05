package com.gcp.gcpspringboottotorial.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gcp.gcpspringboottotorial.domain.User;
import com.gcp.gcpspringboottotorial.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/user/{username}")
	public User findByUsername(@PathVariable String username) {
		LOGGER.info("com.gcp.gcpspringboottotorial.controller.UserController.findByUsername(String)");
		return userService.findByUsername(username);		
	}

	@GetMapping(path = "/user")
	public List<User> findAll() {
		LOGGER.info("com.gcp.gcpspringboottotorial.controller.UserController.findAll()");
		return userService.findAll();		
	}
	
	@PostMapping(path = "/user")
	public User save(@RequestBody User user) {
		LOGGER.info("com.gcp.gcpspringboottotorial.controller.UserController.savel(user)");
		return userService.Save(user);		
	}
	
}
