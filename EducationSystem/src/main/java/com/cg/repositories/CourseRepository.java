package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByCourseName(String name);

}
