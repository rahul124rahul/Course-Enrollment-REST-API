package com.capgemini.courseEnroll.entities;

import java.util.List;

public class StudentHome {
	List<Object[]> famousCourses;
	List<Object[]> popularInstructor;
	
	public StudentHome() {
		// TODO Auto-generated constructor stub
	}

	public StudentHome(List<Object[]> famousCourses, List<Object[]> popularInstructor) {
		super();
		this.famousCourses = famousCourses;
		this.popularInstructor = popularInstructor;
	}

	public List<Object[]> getFamousCourses() {
		return famousCourses;
	}

	public void setFamousCourses(List<Object[]> famousCourses) {
		this.famousCourses = famousCourses;
	}

	public List<Object[]> getPopularInstructor() {
		return popularInstructor;
	}

	public void setPopularInstructor(List<Object[]> popularInstructor) {
		this.popularInstructor = popularInstructor;
	}

	@Override
	public String toString() {
		return "StudentHome [famousCourses=" + famousCourses + ", popularInstructor=" + popularInstructor + "]";
	}
	
	
}
