package com.src.hermes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.src.hermes.helpers.SlugGenerator;

/*
 * Pojo class for team table
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */

@Entity
@Table(name = "team")
public class Team implements Serializable {
	private static final long serialVersionUID = -798012131273957809L;

	@Id
	protected String teamId;

	protected String teamName;
	protected String teamDescription;

	@Transient
	protected String teamLeader;

	protected Date createdOn;

	// bi-directional many-to-one association to TeamEmployeeMapper
	@OneToMany(mappedBy = "team")
	private List<TeamEmployeeMapper> teamEmployeeMappers;

	public Team() {
		this.teamId = "TEAM" + SlugGenerator.randomSlug();
		this.createdOn = new Date();
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamDescription() {
		return teamDescription;
	}

	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
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
