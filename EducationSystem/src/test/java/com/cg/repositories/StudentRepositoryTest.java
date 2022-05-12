package com.cg.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entities.Course;
import com.cg.entities.CourseRegistration;
import com.cg.entities.Student;
import com.cg.payload.StudentDTO;
import com.cg.repositories.CourseRepository;
import com.cg.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void setupTest() {
	}

	@Test
	public void testRequestRegistration()
	{
		Student student = new Student();

		student.setFirstName("Aniketk");
		student.setLastName("karmakark");
		student.setEmailId("aniketk@gmail.com");
		student.setUserName("Aniket");
		student.setContactNumber("8983612958");
		student.setPassword("Aniket$123");

		studentRepository.save(student);
		assertNotNull(student);

	}



	

	@Test
	public void testValidateStudentLogin()
	{
		Student student = studentRepository.findByUserName("ani");

		if (student != null)
		{
			Student student2 = studentRepository.findByUserNameAndPassword("ani", "Prashant#123");
			assertEquals("Prashant", student2.getFirstName());
			
		}
//		else 
//		{
//			assertThrows(NullPointerException.class, () -> {
//				Student student2 = studentRepository.findByUserNameAndPassword("aniket", "Prashant#123");
//				assertTrue(student2.getFirstName());
//			});
//		}

	}

	@Test
	public void testViewAllStudentDetails()
	{
		List<Student> sList = studentRepository.findAll();
		assertNotNull("All Student details", sList);
		
	}

	@Test
	public void testViewStudentById()
	{
		Student studentObj = studentRepository.getOne(8);
		assertEquals("ani", studentObj.getUserName());
		
	}

	@Test
	public void testUpdateStudentDetails()
	{
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setFirstName("Vinay");
		studentDTO.setLastName("Prajapati");
		studentDTO.setEmailId("virusking@gmail.com");
		studentDTO.setContactNumber("7325488745");

		Student student = new Student();
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmailId(studentDTO.getEmailId());
		student.setContactNumber(studentDTO.getContactNumber());
		student.setPassword(student.getPassword());
		
		Student updateStudentObj = studentRepository.save(student);
		assertEquals(studentDTO.getFirstName(), updateStudentObj.getFirstName());
		
	}

	@Test
	public void testViewCourseForStudent()
	{
		Student student = studentRepository.getOne(1);
		List<CourseRegistration> listOfCourses = student.getRegistrations();
		
		assertEquals(5, listOfCourses.size());

		assertEquals("Java", listOfCourses.get(1).getCourse().toString());
		
	}

//	@Test
//	public void updateStudentForCourse()
//	{
//		Student student = studentRepository.getOne(9);
//		List<Course> courseList = new ArrayList<Course>();
//		Course course = courseRepository.findByCourseName("Python");
//		courseList.add(course);
//		
//		student.setPassword(student.getPassword());
//		student.setCourses(courseList);
//		
//		studentRepository.save(student);
//
//		assertEquals("Python", student.getCourses().get(0).getCourseName());
//
//	}

//	@Test
//	public void findByCourseName()
//	{
//		Course course = courseRepository.findByCourseName("Java");
//		assertEquals("Java", course.getCourseName());
//
//	}

//	@Test
//	public void findByUserName()
//	{
//		Student student = studentRepository.findByUserName("ani");
//		assertNotNull(student);
//		
//	}

//	@Test
//	public void findByEmailId()
//	{
//		Student student = studentRepository.findByEmailId("aniK@gmail.com");
//		assertNull(student);
//		
//	}


	@Test
	public void findByUserNameAndPassword()
	{
		Student student = studentRepository.findByUserNameAndPassword("aniket", "Aniket$123");
		assertNotNull(student);
		
	}


}
