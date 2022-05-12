package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
   @Query("Select a from Admin a where a.userName=?1 and a.password=?2")
	public Admin findByUserNameAndPassword(String userName, String password);
  
}
