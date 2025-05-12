package com.capgemini.courseEnroll.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "User Id is mendentory")
	private Long userId;
	
	@NotNull(message = "Course Id is mendentory")
	private Long courseId;
	
	@NotNull(message = "Date of joining must be provided")
	private LocalDate enrollmentDate;
	
	
	public Enrollment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Enrollment(Long id, @NotNull(message = "User Id is mendentory") Long userId,
			@NotNull(message = "Course Id is mendentory") Long courseId,
			@NotNull(message = "Date of joining must be provided") LocalDate enrollmentDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
		this.enrollmentDate = enrollmentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	
	
}
