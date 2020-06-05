package com.gcp.gcpspringboottotorial.service;

import java.util.List;

import com.gcp.gcpspringboottotorial.domain.User;

public interface UserService {
	
	List<User> findAll();
	
	User findByUsername(String username);
	
	User Save(User user);

}
