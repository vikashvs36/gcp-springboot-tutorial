package com.gcp.gcpspringboottotorial.controller;

import java.util.List;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gcp.gcpspringboottotorial.domain.User;
import com.gcp.gcpspringboottotorial.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Value("gs://vikashmart-storage/testing/GCP")
	private Resource gcsResource;
	
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
	
	@GetMapping(path = "/file")
	public String storage() throws Exception {
		LOGGER.info("com.gcp.gcpspringboottotorial.controller.UserController.storage()");
		return StreamUtils.copyToString(
				this.gcsResource.getInputStream(),
				Charset.defaultCharset()) + "\n";
	}
	
	@PostMapping(path = "/file")
	public String upload(@RequestParam MultipartFile data) throws Exception {
		LOGGER.info("com.gcp.gcpspringboottotorial.controller.UserController.upload()");
		try (OutputStream os = ((WritableResource) this.gcsResource).getOutputStream()) {
			os.write(data.getBytes());
		}
		return "file was updated\n";
	}
	
}
