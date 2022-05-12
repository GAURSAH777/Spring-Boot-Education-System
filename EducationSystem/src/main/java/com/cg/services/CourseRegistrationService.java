package com.cg.services;

import java.util.List;

import com.cg.entities.CourseRegistration;

public interface CourseRegistrationService {

	public CourseRegistration saveCourseRegistration(CourseRegistration courseReg);

	public CourseRegistration getCourseRegById(int courseRegId);

	public List<CourseRegistration> getAllCourseRegs();

	public CourseRegistration updateCourseReg(CourseRegistration courseReg);

	public void deleteCourseRegById(int courseRegId);

}
