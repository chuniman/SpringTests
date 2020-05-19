package com.educacionit.student.api.model;

public class AuthorizationToken {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthorizationToken(String token) {
		this.token = token;
	}
	
	
}
