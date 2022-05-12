package com.cg;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.controller.CourseController;

@SpringBootTest
class EducationSystemApplicationTests {

	@Autowired
	CourseController controller;

	@Test
	void contextLoads() {
		Assert.assertNotNull(controller);
	}

}
