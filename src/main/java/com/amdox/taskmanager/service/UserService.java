package com.amdox.taskmanager.service;

import com.amdox.taskmanager.dto.AuthResponse;
import com.amdox.taskmanager.dto.UserLoginRequest;
import com.amdox.taskmanager.dto.UserRegisterRequest;

public interface UserService {

	AuthResponse register(UserRegisterRequest registerRequest);

	String login(UserLoginRequest loginRequest);
	
}
