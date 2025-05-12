package com.capgemini.courseEnroll.dto;

public class EnrolledCourseDTO {
    private Long enrollmentId;
    private Long courseId;
    private String title;
    private String description;
    private Double fee;
    private String instructorName;
    
    
    public EnrolledCourseDTO() {
		// TODO Auto-generated constructor stub
	}
    
 	public EnrolledCourseDTO(Long enrollmentId, Long courseId, String title, String description, Double fee,
			String instructorName) {
		super();
		this.enrollmentId = enrollmentId;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.fee = fee;
		this.instructorName = instructorName;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public String toString() {
		return "EnrolledCourseDTO [enrollmentId=" + enrollmentId + ", courseId=" + courseId + ", title=" + title
				+ ", description=" + description + ", fee=" + fee + ", instructorName=" + instructorName + "]";
	}
    
    
    
}
