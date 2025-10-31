package com.amdox.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdox.taskmanager.dto.AuthResponse;
import com.amdox.taskmanager.dto.UserLoginRequest;
import com.amdox.taskmanager.dto.UserRegisterRequest;
import com.amdox.taskmanager.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterRequest request) {
		AuthResponse response = this.userService.register(request);
		return new ResponseEntity<AuthResponse>(response, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
		String response = this.userService.login(request);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}

}
