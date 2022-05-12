package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByUserNameAndPassword(String username, String password);

	public Student findByUserName(String username);

	public Student findByEmailId(String emailId);
}
