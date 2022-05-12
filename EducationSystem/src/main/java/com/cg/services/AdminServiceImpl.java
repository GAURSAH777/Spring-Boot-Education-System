package com.cg.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Admin;
import com.cg.exception.AuthenticationFailureException;
//import com.cg.exceptions.InvalidAdminException;
import com.cg.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

	// autowiring repository interface
	@Autowired
	public AdminRepository adminRepo;

	// implement method
	@Override
	public Admin adminLogin(String adminUsername, String adminPassword) throws AuthenticationFailureException {

		LOGGER.info("admin login method of adminServiceImp class called-START");

		Admin admin = adminRepo.findByUserNameAndPassword(adminUsername, adminPassword);

		if (admin == null) {

			throw new AuthenticationFailureException("Invalid admin username and password!");
		} else {

			return admin;
		}
	}

}
