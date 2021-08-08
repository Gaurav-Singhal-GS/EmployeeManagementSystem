package com.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login {
	
	@Id
	private int id;
	private String password;
	private String role;
	
	public Login() {
		//Default Constructor
	}

	public Login(int id, String password, String role) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + ", role=" + role + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
