package com.cg.services;

import java.util.List;
import com.cg.entities.Test;

public interface TestService {

	public Test saveTest(Test test);

	public Test getTestById(int testId);

	public List<Test> getAllTests();

	public Test updateTest(Test test);

	public void deleteTestById(int testId);

}
