package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Course;
import com.cg.entities.CourseRegistration;
import com.cg.entities.Student;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.CourseRegistrationRepository;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

	@Autowired
	private CourseRegistrationRepository courseRegistrationRepo;

	@Override
	public CourseRegistration saveCourseRegistration(CourseRegistration courseReg) {
		CourseRegistration savedCourseReg = courseRegistrationRepo.save(courseReg);
		return savedCourseReg;
	}

	@Override
	public CourseRegistration getCourseRegById(int courseRegId) {
		Optional<CourseRegistration> optionalCourseReg = courseRegistrationRepo.findById(courseRegId);
		if (optionalCourseReg == null)
			throw new ResourceNotFoundException("CourseRegistration Not found with id : " + courseRegId);
		CourseRegistration courseReg = optionalCourseReg.get();
		return courseReg;
	}

	@Override
	public List<CourseRegistration> getAllCourseRegs() {
		List<CourseRegistration> courseRegs = courseRegistrationRepo.findAll();
		return courseRegs;
	}

	@Override
	public CourseRegistration updateCourseReg(CourseRegistration courseReg) {
		CourseRegistration updatedCourseReg = getCourseRegById(courseReg.getId());
		updatedCourseReg = courseRegistrationRepo.save(courseReg);
		return updatedCourseReg;
	}

	@Override
	public void deleteCourseRegById(int courseRegId) {
		CourseRegistration course = getCourseRegById(courseRegId);
		courseRegistrationRepo.delete(course);
	}

}
