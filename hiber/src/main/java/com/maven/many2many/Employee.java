package com.maven.many2many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int empid;
	private String name;
	@ManyToMany
	private List<Project> proj;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String name, List<Project> proj) {
		super();
		this.empid = empid;
		this.name = name;
		this.proj = proj;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProj() {
		return proj;
	}
	public void setProj(List<Project> proj) {
		this.proj = proj;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + "]";
	}
	
	
}
