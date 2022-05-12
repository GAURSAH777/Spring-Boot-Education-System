package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {

	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	@Column(name = "admin_username")
	private String userName;

	@Column(name = "admin_password")
	private String password;

	public Admin() {
		super();
	}

	public Admin(final String userName, final String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(final int adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}

}
