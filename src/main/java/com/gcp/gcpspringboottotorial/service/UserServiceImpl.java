package com.gcp.gcpspringboottotorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcp.gcpspringboottotorial.domain.User;
import com.gcp.gcpspringboottotorial.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User Save(User user) {
		return userRepository.save(user);
	}

}
