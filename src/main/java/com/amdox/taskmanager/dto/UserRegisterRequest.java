package com.amdox.taskmanager.dto;

import com.amdox.taskmanager.constant.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterRequest {

	private String name;

	private String email;

	private String password;

	private Role role;
}
