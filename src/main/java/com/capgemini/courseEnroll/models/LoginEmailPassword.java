package com.capgemini.courseEnroll.models;

public class LoginEmailPassword {
	String email;
	String Password;
	
	public LoginEmailPassword() {
		// TODO Auto-generated constructor stub
	}

	public LoginEmailPassword(String email, String password) {
		super();
		this.email = email;
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
