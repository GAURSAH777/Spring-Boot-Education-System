package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Test;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.TestRepository;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestRepository testRepo;

	@Override
	public Test saveTest(Test test) {
		Test savedTest = testRepo.save(test);
		return savedTest;
	}

	@Override
	public Test getTestById(int testId) {
		Optional<Test> optionalTest = testRepo.findById(testId);
		if (optionalTest == null)
			throw new ResourceNotFoundException("Test Not found with id : " + testId);
		Test test = optionalTest.get();
		return test;
	}

	@Override
	public List<Test> getAllTests() {
		List<Test> tests = testRepo.findAll();
		return tests;
	}

	@Override
	public Test updateTest(Test test) {
		Test updatedTest = getTestById(test.getTestId());
		updatedTest = testRepo.save(test);
		return updatedTest;
	}

	@Override
	public void deleteTestById(int testId) {
		Test test = getTestById(testId);
		testRepo.delete(test);
	}

}
