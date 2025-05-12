package com.capgemini.courseEnroll.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 3, message = "At least 5 characters")
	String name;

	@NotBlank(message = "This field is required.")
	@Size(min=4,message = "Min length = 4 characters")
	String expertise;

	public Instructor() {
		// TODO Auto-generated constructor stub
	}


	public Instructor(Long id,
			@NotBlank(message = "Name is required") @Size(min = 3, message = "At least 5 characters") String name,
			@NotBlank(message = "This field is required.") @Size(min = 4, message = "Min length = 4 characters") String expertise) {
		super();
		this.id = id;
		this.name = name;
		this.expertise = expertise;
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

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", expertise=" + expertise + "]";
	}

}
