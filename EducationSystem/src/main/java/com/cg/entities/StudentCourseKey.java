package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCourseKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "course_id")
	private Integer courseId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

}
