package com.capgemini.courseEnroll.dto;

public class CourseDetailsDTO {
    private Long id;
    private String title;
    private String description;
    private Double fee;
    private String instructorName;
    public Long instructorId;
    
    public CourseDetailsDTO(Long id, String title, String description, Double fee, String instructorName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.instructorName = instructorName;
    }

    
    public CourseDetailsDTO(Long id, String title, String description, Double fee, String instructorName, Long instructorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.instructorName = instructorName;
        this.instructorId = instructorId;
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
	
	

	public Long getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}


	@Override
	public String toString() {
		return "CourseDetailsDTO [id=" + id + ", title=" + title + ", description=" + description + ", fee=" + fee
				+ ", instructorName=" + instructorName + ", instructorId=" + instructorId + "]";
	}


	
    
}
