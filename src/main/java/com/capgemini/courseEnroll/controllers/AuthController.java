package com.capgemini.courseEnroll.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.courseEnroll.dto.LoginDto;
import com.capgemini.courseEnroll.entities.User;
import com.capgemini.courseEnroll.exceptions.EmailAlreadyExist;
import com.capgemini.courseEnroll.models.ResponseToken;
import com.capgemini.courseEnroll.security.JwtUtils;
import com.capgemini.courseEnroll.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	AuthenticationManager authenticationManager;
	UserService userService;
	PasswordEncoder passwordEncoder;
	JwtUtils jwtService;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, UserService userService,
			PasswordEncoder passwordEncoder, JwtUtils jwtService) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		if (authentication.isAuthenticated()) {
			User user = userService.findByNameOrEmail(loginDto.getUsername(), loginDto.getUsername());
			Map<String, Object> claims = new HashMap<>();
			claims.put("email", user.getEmail());
			claims.put("name", user.getName());
			claims.put("userid", user.getId());
			claims.put("userPassword", user.getPassword());
			claims.put("phone", user.getPhone());
			claims.put("usertype", user.getUserType());
			String token = jwtService.generateToken(loginDto.getUsername(), claims);
			ResponseToken responseToken = new ResponseToken(token);
			return ResponseEntity.status(HttpStatus.OK).body(responseToken);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not Authorized !!");
	}

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		if (userService.existsByName(user.getName()) || userService.existsByEmail(user.getEmail()))
			throw new EmailAlreadyExist("Username or Email Exists !");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,user));
	}
	
	
}
