package com.capgemini.courseEnroll.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NotBlank
	@Size(min = 2, max=50 , message = "Characters length = 2 to 22")
	String title;

	@NotBlank
	@Size(min = 4, message = "Field shoulud have at least 4 characters.")
	String description;

	@NotNull(message = "Salary must be provided")
	int instructorId;
	
	@NotNull(message = "Salary must be provided")
	@Positive(message = "Salary must be positive")
	double fee;
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	

	public Course(Long id, @NotBlank @Size(min = 2, max = 22, message = "Characters length = 2 to 22") String title,
			@NotBlank @Size(min = 4, message = "Field shoulud have at least 4 characters.") String description,
			@NotNull(message = "Salary must be provided") int instructorId,
			@NotNull(message = "Salary must be provided") @Positive(message = "Salary must be positive") double fee) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.instructorId = instructorId;
		this.fee = fee;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", description=" + description + ", instructorId="
				+ instructorId + ", fee=" + fee + "]";
	}

}
