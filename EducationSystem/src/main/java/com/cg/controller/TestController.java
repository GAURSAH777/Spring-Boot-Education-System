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
import com.cg.entities.Test;
import com.cg.services.TestService;

@CrossOrigin("*")
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;

	@GetMapping("/all")
	public List<Test> fetchAllTest() {

		List<Test> test = testService.getAllTests();
		return test;
	}

	@PostMapping("/save")
	public ResponseEntity<Test> addTest(@Valid @RequestBody Test test) {

		Test newTest = testService.saveTest(test);
		ResponseEntity<Test> responseEntity = new ResponseEntity<>(newTest, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchTestById(@PathVariable("id") int testId) {

		ResponseEntity<?> responseEntity = null;
		Test test = testService.getTestById(testId);
		responseEntity = new ResponseEntity<>(test, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTestById(@PathVariable("id") int testId) {

		ResponseEntity<String> responseEntity = null;
		testService.deleteTestById(testId);
		responseEntity = new ResponseEntity<>("Test deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateTest(@RequestBody Test test) {

		ResponseEntity<Object> responseEntity = null;
		Test updatedTest = testService.updateTest(test);
		responseEntity = new ResponseEntity<>(updatedTest, HttpStatus.OK);
		return responseEntity;
	}

}
