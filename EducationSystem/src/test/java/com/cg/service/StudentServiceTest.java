package com.cg.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entities.Course;
import com.cg.entities.Student;
import com.cg.payload.StudentDTO;
import com.cg.repositories.StudentRepository;
import com.cg.services.StudentServiceImpl;

@SpringBootTest
class StudentServiceTest {

	@InjectMocks
	StudentServiceImpl studentService;

	@Mock
	private StudentRepository studentRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testRequestRegistration() {
		Student student = new Student();

		student.setStudentId(2);
		student.setFirstName("Aniketk");
		student.setLastName("karmakark");
		student.setEmailId("aniketk@gmail.com");
		student.setUserName("Aniket");//
		student.setContactNumber("8983612958");
		student.setPassword("Aniket$123");

		when(studentRepository.saveAndFlush(any())).thenReturn(student);
		boolean result = studentService.requestRegistration(student);
		assertTrue(result);

	}

//	@Test
//	void testValidateStudentLogin() throws StudentNotFoundException, RegistrationRequestNotApprovedException
//	{
//		String username = "aniket";
//		String password = "Aniket$123";
//		
//		Student student = new Student();
//		
//		student.setStudentId(1);
//		student.setFirstName("Anikettt");
//		student.setMiddleName("keshavv");
//		student.setLastName("kar");
//		student.setEmailId("aniket@gma.com");
//		student.setContactNumber("8983612955");
//		student.setUserName("aniket");
//		student.setPassword("Aniket$123");
//		student.setConfirmPassword("Aniket$123");
//		student.setValidate(true);
//
//		when(studentRepository.findByUserName(anyString())).thenReturn(student);
//		boolean isValid = studentService.validateStudentLogin(username, password);
//		assertFalse(isValid);
//
//	}

	@Test
	void testViewAllStudentDetails() {
		Student student = new Student();

		student.setStudentId(1);
		student.setFirstName("Aniket");
		student.setLastName("karmakar");
		student.setEmailId("aniket@gmail.com");
		student.setContactNumber("8983612955");
		student.setPassword("Aniket$123");

		Student student2 = new Student();

		student2.setStudentId(1);
		student2.setFirstName("Aniket");
		student2.setLastName("karmakar");
		student2.setEmailId("aniket@gmail.com");
		student2.setContactNumber("8983612955");
		student2.setPassword("Aniket$123");

		List<Student> viewAllStudentDetails = new ArrayList<Student>();
		viewAllStudentDetails.add(student);
		viewAllStudentDetails.add(student2);
		when(studentRepository.findAll()).thenReturn(viewAllStudentDetails);
		List<Student> studentList = studentService.getAllStudents();
		assertEquals(2, studentList.size());

	}

//	@Test
//	void testViewStudentById() {
//		Student student2 = new Student();
//
//		student2.setStudentId(1);
//		student2.setFirstName("Aniket");
//		student2.setLastName("karmakar");
//		student2.setEmailId("aniket@gmail.com");
//		student2.setContactNumber("8983612955");
//		student2.setPassword("Aniket$123");
//
//		when(studentRepository.getOne(anyInt())).thenReturn(student2);
//
//		Student student = studentService.getStudentById(1);
//		assertEquals(student2.getLastName(), student.getLastName());
//
//	}

//	@Test
//	void testUpdateStudentDetails() {
//		StudentDTO student = new StudentDTO();
//
//		student.setFirstName("Aniket");
//		student.setLastName("kar");
//		student.setEmailId("ani@gmail.com");
//		student.setContactNumber("8798548511");
//
//		Student student2 = new Student();
//
//		student2.setStudentId(1);
//		student2.setFirstName("Aniket");
//		student2.setLastName("karmakar");
//		student2.setEmailId("aniket@gmail.com");
//		student2.setContactNumber("8983612955");
//		student2.setPassword("Aniket$123");
//
//		when(studentRepository.save(any())).thenReturn(student2);
//
//		assertThrows(NullPointerException.class, () -> {
//			studentService.updateStudent(student2);
//		});
//
//	}

//	@Test
//	void testViewCourseForStudent(){
//		Student student = new Student();
//
//		student.setStudentId(1);
//		student.setFirstName("Aniket");
//		student.setLastName("karmakar");
//		student.setEmailId("aniket@gmail.com");
//		student.setContactNumber("8983612955");
//		student.setPassword("Aniket$123");
//
//		Course c = new Course();
//
//		c.setCourseId(1);
//		c.setCourseName("Java");
//		c.setHours(8);
//
//		List<Course> ar = new ArrayList<Course>();
//		ar.add(c);
//
//		student.setCourses(ar);
//
//		when(studentRepository.getOne(any())).thenReturn(student);
//		List<Course> listCourse = studentService.viewCourseForStudent(1);
//		assertEquals("Java", listCourse.get(0).getCourseName());
//
//	}
//

}
