package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentid")
	private int id;
	
	@Column(name = "departmentname")
	private String name;

	/*Constructors*/
	public Department() {
		//default Constructor
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
