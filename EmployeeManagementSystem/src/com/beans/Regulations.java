package com.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Regulations {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int regId;
	
	private String regType;
	private String details;
	private Date createDate;
	
	@ManyToOne
	private Department dept;
	
	public Regulations() {
		//Default Constructor
	}
	
	public Regulations(String regType, String details, Date createDate, Department dept) {
		super();
		this.regType = regType;
		this.details = details;
		this.createDate = createDate;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Regulations [regId=" + regId + ", regType=" + regType + ", details=" + details + ", createDate="
				+ createDate + ", dept=" + dept + "]";
	}

	public int getRegId() {
		return regId;
	}

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}
