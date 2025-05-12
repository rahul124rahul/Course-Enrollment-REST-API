package com.capgemini.courseEnroll.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "User name is mendentory.")
	private String name;

	@Email(message = "Enter valid email")
	private String email;

	@NotBlank(message = "Enter valid password")
	private String password;

	@NotBlank(message = "This field is compulsary.")
	private String phone;

	@NotBlank(message = "UserType is mendentory")
	private String userType;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long id, @NotBlank(message = "User name is mendentory.") String name,
			@Email(message = "Enter valid email") String email,
			@NotBlank(message = "Enter valid password") String password,
			@NotBlank(message = "This field is compulsary.") String phone,
			@NotBlank(message = "UserType is mendentory") String userType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", userType=" + userType + "]";
	}

}
