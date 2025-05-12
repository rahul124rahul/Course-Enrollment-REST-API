package com.capgemini.courseEnroll.entities;

import java.util.List;

public class AdminDashboardEntity {
	int coursesCount;
	int enrollmentCount;
	int instructorCount;
	int studentCount;

	List<Object[]> courseSales;
	List<Object[]> instructorWiseCourses;
	List<Object[]> instructorWiseCourseSale;

	public AdminDashboardEntity() {
		// TODO Auto-generated constructor stub
	}

	public AdminDashboardEntity(int coursesCount, int enrollmentCount, int instructorCount, int studentCount,
			List<Object[]> courseSales, List<Object[]> instructorWiseCourses, List<Object[]> instructorWiseCourseSale) {
		super();
		this.coursesCount = coursesCount;
		this.enrollmentCount = enrollmentCount;
		this.instructorCount = instructorCount;
		this.studentCount = studentCount;
		this.courseSales = courseSales;
		this.instructorWiseCourses = instructorWiseCourses;
		this.instructorWiseCourseSale = instructorWiseCourseSale;
	}

	public int getCoursesCount() {
		return coursesCount;
	}

	public void setCoursesCount(int coursesCount) {
		this.coursesCount = coursesCount;
	}

	public int getEnrollmentCount() {
		return enrollmentCount;
	}

	public void setEnrollmentCount(int enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public int getInstructorCount() {
		return instructorCount;
	}

	public void setInstructorCount(int instructorCount) {
		this.instructorCount = instructorCount;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public List<Object[]> getCourseSales() {
		return courseSales;
	}

	public void setCourseSales(List<Object[]> courseSales) {
		this.courseSales = courseSales;
	}

	public List<Object[]> getInstructorWiseCourses() {
		return instructorWiseCourses;
	}

	public void setInstructorWiseCourses(List<Object[]> instructorWiseCourses) {
		this.instructorWiseCourses = instructorWiseCourses;
	}

	public List<Object[]> getInstructorWiseCourseSale() {
		return instructorWiseCourseSale;
	}

	public void setInstructorWiseCourseSale(List<Object[]> instructorWiseCourseSale) {
		this.instructorWiseCourseSale = instructorWiseCourseSale;
	}

	@Override
	public String toString() {
		return "AdminDashboardEntity [coursesCount=" + coursesCount + ", enrollmentCount=" + enrollmentCount
				+ ", instructorCount=" + instructorCount + ", studentCount=" + studentCount + ", courseSales="
				+ courseSales + ", instructorWiseCourses=" + instructorWiseCourses + ", instructorWiseCourseSale="
				+ instructorWiseCourseSale + "]";
	}

}
