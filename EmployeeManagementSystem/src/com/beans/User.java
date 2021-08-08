package com.beans;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "firstname")
	private String fname;
	
	@Column(name = "lastname")
	private String lname;
	
	private Date dob;
	private String email;
	
	@OneToOne
	private Department dep;
	
	public User() {
		//default constructor
	}

	public User(String fname, String lname, Date dob, String email, Department dep) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "user [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", email=" + email
				+ "]";
	}
	
	public int getUserId() {
		return userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

}
