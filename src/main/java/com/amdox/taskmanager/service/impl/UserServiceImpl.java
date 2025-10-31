package com.amdox.taskmanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amdox.taskmanager.dto.AuthResponse;
import com.amdox.taskmanager.dto.UserLoginRequest;
import com.amdox.taskmanager.dto.UserRegisterRequest;
import com.amdox.taskmanager.entity.User;
import com.amdox.taskmanager.repository.UserRepository;
import com.amdox.taskmanager.security.JwtUtil;
import com.amdox.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public AuthResponse register(UserRegisterRequest request) {

		Optional<User> userOpt = this.userRepository.findByEmail(request.getEmail());
		if (userOpt.isPresent()) {
			throw new RuntimeException("User already exist.");
		}

		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(this.bCryptPasswordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		this.userRepository.save(user);
		String token = this.jwtUtil.generateToken(user.getEmail());

		return new AuthResponse(token, "User registered successfully.");
	}

	@Override
	public String login(UserLoginRequest request) {
		Optional<User> userOpt = this.userRepository.findByEmail(request.getEmail());
		if (userOpt.isEmpty()) {
			throw new RuntimeException("User not found.");
		}

		if (!this.bCryptPasswordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
			throw new RuntimeException("Invalid credentials.");
		}

		return this.jwtUtil.generateToken(userOpt.get().getEmail());
	}

}
