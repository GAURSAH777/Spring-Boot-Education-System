package com.cg.services;

import com.cg.entities.Admin;

public interface AdminService {

	Admin adminLogin(String adminUsername, String adminPassword);

}
