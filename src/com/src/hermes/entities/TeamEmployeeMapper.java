package com.src.hermes.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.src.hermes.helpers.SlugGenerator;

/*
 * Pojo class for team_employee_mapper table
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */

@Entity
@Table(name = "team_employee_mapper")
public class TeamEmployeeMapper implements Serializable {
	private static final long serialVersionUID = 5109221104258584273L;

	/**
	 * Persistence Id.
	 */
	@Id
	private String mapperId;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "empRefId")
	private Employee employee;

	// bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name = "teamRefId")
	private Team team;

	protected boolean isLeader;
	protected boolean isAssigned;

	public TeamEmployeeMapper() {
		this.mapperId = "MAPR" + SlugGenerator.randomSlug();
	}

	public String getMapperId() {
		return mapperId;
	}

	public void setMapperId(String mapperId) {
		this.mapperId = mapperId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
}