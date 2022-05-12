package com.cg.services;

import java.util.List;

import com.cg.entities.Course;
import com.cg.entities.Student;
import com.cg.entities.Trainer;

public interface CourseService {

	public Course saveCourse(Course course);

	public Course getCourseById(int courseId);

	public List<Course> getAllCourses();

	public Course updateCourse(Course course);

	public void deleteCourseById(int courseId);

	Course updateCourseForTrainers(int courseId, String firstName);

//	Course updateCourseForStudents(int courseId, String userName);

	Trainer viewTrainers(int courseId);

//	List<Student> viewStudents(int courseId);

}
