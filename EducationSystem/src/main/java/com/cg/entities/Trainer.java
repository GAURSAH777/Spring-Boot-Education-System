package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trainer_tbl")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainer_id", nullable = false)
	private int trainerId;

	@Column(name = "first_name", nullable = false)
	private String firstName;	

	@Column(name = "last_name", nullable = false)
	private String lastName;	
	
	@JsonIgnore
	@OneToOne(mappedBy = "trainer", cascade = CascadeType.ALL)
	private Course course;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
