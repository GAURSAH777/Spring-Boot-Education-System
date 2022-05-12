package com.cg.services;

import java.util.List;

import com.cg.entities.CourseRegistration;
import com.cg.entities.Student;

public interface StudentService {

	boolean requestRegistration(Student student);

	public Student studentLogin(String username, String password);

	public List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student getStudentById(int studentId);

	public void deleteStudent(int studentId);

	public Student updateStudent(Student student);

	List<CourseRegistration> viewCourseForStudent(int studentId);

//	Student updateStudentForCourse(int id, String name);

}
