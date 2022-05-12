package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entities.CourseRegistration;
import com.cg.services.CourseRegistrationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/courseReg")
public class CourseRegistrationController {

	@Autowired
	private CourseRegistrationService courseRegistrationService;

	@GetMapping("/getAll")
	public List<CourseRegistration> fetchAllCourseRegs() {

		List<CourseRegistration> courses = courseRegistrationService.getAllCourseRegs();
		return courses;
	}

	@PostMapping("/save")
	public ResponseEntity<CourseRegistration> addCourseReg(@Valid @RequestBody CourseRegistration courseReg) {

		CourseRegistration newCourse = courseRegistrationService.saveCourseRegistration(courseReg);
		ResponseEntity<CourseRegistration> responseEntity = new ResponseEntity<>(newCourse, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchCourseRegById(@PathVariable("id") int courseRegId) {

		ResponseEntity<?> responseEntity = null;
		CourseRegistration course = courseRegistrationService.getCourseRegById(courseRegId);
		responseEntity = new ResponseEntity<>(course, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourseRegById(@PathVariable("id") int courseRegId) {

		ResponseEntity<String> responseEntity = null;
		courseRegistrationService.deleteCourseRegById(courseRegId);
		responseEntity = new ResponseEntity<>("Course Registration deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateCourseReg(@RequestBody CourseRegistration courseReg) {

		ResponseEntity<Object> responseEntity = null;
		CourseRegistration updatedCourseReg = courseRegistrationService.updateCourseReg(courseReg);
		responseEntity = new ResponseEntity<>(updatedCourseReg, HttpStatus.OK);
		return responseEntity;
	}

}
