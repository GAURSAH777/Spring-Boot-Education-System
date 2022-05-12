package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.CourseRegistration;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {

//	CourseRegistration findByCourseRegName(String name);

}
