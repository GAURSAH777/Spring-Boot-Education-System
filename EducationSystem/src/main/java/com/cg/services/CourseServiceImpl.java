package com.cg.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entities.Course;
import com.cg.entities.Student;
import com.cg.entities.Trainer;
import com.cg.exception.ResourceAlreadyExistException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.CourseRepository;
import com.cg.repositories.TrainerRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private TrainerRepository trainerRepo;

	@Override
	public Course saveCourse(Course course) {
		Course savedCourse = courseRepo.save(course);
		return savedCourse;
	}

	@Override
	public Course getCourseById(int courseId) {
		Optional<Course> optionalCourse = courseRepo.findById(courseId);
		if (optionalCourse == null)
			throw new ResourceNotFoundException("Course Not found with id : " + courseId);
		Course course = optionalCourse.get();
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepo.findAll();
		return courses;
	}

	@Override
	public Course updateCourse(Course course) {
		Course updatedCourse = getCourseById(course.getCourseId());
		updatedCourse = courseRepo.save(course);
		return updatedCourse;
	}

	@Override
	public void deleteCourseById(int courseId) {
		Course course = getCourseById(courseId);
		courseRepo.delete(course);
	}

	@Override
	public Course updateCourseForTrainers(int courseId, String firstName) {
		Course course = courseRepo.findById(courseId).orElse(null);
		courseRepo.save(course);
		return course;
	}

//	@Override
//	public Course updateCourseForStudents(final int courseId, final String userName){
//		final Course course = courseRepo.findById(courseId).orElse(null);
//		if (course != null) {
//			final List<Student> studentList = course.getStudent();
//
//			final List<String> usernameList = studentList.stream().map(e -> e.getUserName())
//					.collect(Collectors.toList());
//			if (usernameList.contains(userName)) {
//				throw new AlreadyExistsException("Student Already Enrolled in Course ");
//			} else {
//				final List<Student> slist = new ArrayList<Student>();
//				final Student student = studentRepo.findByUserName(userName);
//
//				slist.add(student);
//				course.setStudents(slist);
//				courseRepo.save(course);
//				return course;
//			}
//		} else {
//			throw new ResourceNotFoundException("Student cannot be added");
//		}
//
//	}

	@Override
	public Trainer viewTrainers(final int courseId) {
		Course course = courseRepo.getOne(courseId);
		Trainer trainerList = course.getTrainer();
			return trainerList;

	}

//	@Override
//	public List<Student> viewStudents(final int courseId){
//		 Course course = courseRepo.getOne(courseId);
//		 List<Student> students = course.getStudent();
//		if (students.size() > 0) {
//			return students;
//		} else {
//			throw new ResourceNotFoundException("No students to show!");
//		}
//
//	}
	
	

}
