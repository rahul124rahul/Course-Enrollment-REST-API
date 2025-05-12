package com.capgemini.courseEnroll.models;

public class CourseSales {
	Long CourseId;
//	String Title;
	Long courseCount;
	
	
	
	public CourseSales() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CourseSales(Long courseId, Long courseCount) {
		super();
		CourseId = courseId;
		this.courseCount = courseCount;
	}



	public Long getCourseId() {
		return CourseId;
	}

	public void setCourseId(Long courseId) {
		CourseId = courseId;
	}

	public Long getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(Long courseCount) {
		this.courseCount = courseCount;
	}



	@Override
	public String toString() {
		return "CourseSales [CourseId=" + CourseId + ", courseCount=" + courseCount + "]";
	}
	
	
	
	
	
	
}
