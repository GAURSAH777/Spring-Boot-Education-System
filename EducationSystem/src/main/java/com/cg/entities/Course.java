package com.cg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course_tbl")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_Id", nullable = false)
	private int courseId;

	@Column(name = "course_name", nullable = false)
	private String courseName;

	@Column(name = "course_amount", nullable = false)
	private double courseAmount;

	@Column(name = "hours")
	private float hours;

	@OneToOne
	private Trainer trainer;

	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	private Test test;

	@OneToMany(mappedBy = "course")
	private List<StudyMaterial> studyMaterials = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<CourseRegistration> registrations = new ArrayList<>();

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseAmount() {
		return courseAmount;
	}

	public void setCourseAmount(double courseAmount) {
		this.courseAmount = courseAmount;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<StudyMaterial> getStudyMaterials() {
		return studyMaterials;
	}

	public void setStudyMaterials(List<StudyMaterial> studyMaterials) {
		this.studyMaterials = studyMaterials;
	}

	public List<CourseRegistration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<CourseRegistration> registrations) {
		this.registrations = registrations;
	}

}
