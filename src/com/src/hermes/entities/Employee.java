package com.src.hermes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.src.hermes.helpers.SlugGenerator;

/*
 * Pojo class for employee table
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = -6747066856199843422L;

	/**
	 * Persistence Id.
	 */
	@Id
	protected String empId;

	protected String fname;
	protected String lname;
	protected String skills;
	protected Date createdOn;

	// bi-directional many-to-one association to TeamEmployeeMapper
	@OneToMany(mappedBy = "employee")
	private List<TeamEmployeeMapper> teamEmployeeMappers;

	public Employee() {
		this.empId = "EMPL" + SlugGenerator.randomSlug();
		this.createdOn = new Date();
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<TeamEmployeeMapper> getTeamEmployeeMappers() {
		return teamEmployeeMappers;
	}

	public void setTeamEmployeeMappers(
			List<TeamEmployeeMapper> teamEmployeeMappers) {
		this.teamEmployeeMappers = teamEmployeeMappers;
	}

}