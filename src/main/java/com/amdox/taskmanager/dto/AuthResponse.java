package com.amdox.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
	private String token;
	private String message;
	private String type = "Bearer";

	public AuthResponse(String token, String message) {
		this.token = token;
		this.message = message;
	}
}
