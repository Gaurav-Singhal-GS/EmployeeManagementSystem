package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Report {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusId;
	private String comments;
	private String creatDate;
	
	@ManyToOne
	private Regulations reg;
	
	@ManyToOne
	private User emp;
	
	@ManyToOne
	private Department dep;
	
	public Report() {
		//Default Constructor
	}

	public Report(String comments, String creatDate, Regulations reg, User emp, Department dep) {
		super();
		this.comments = comments;
		this.creatDate = creatDate;
		this.reg = reg;
		this.emp = emp;
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Report [statusId=" + statusId + ", comments=" + comments + ", creatDate=" + creatDate + ", reg=" + reg
				+ ", emp=" + emp + ", dep=" + dep + "]";
	}

	public int getStatusId() {
		return statusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public Regulations getReg() {
		return reg;
	}

	public void setReg(Regulations reg) {
		this.reg = reg;
	}

	public User getEmp() {
		return emp;
	}

	public void setEmp(User emp) {
		this.emp = emp;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}
}
