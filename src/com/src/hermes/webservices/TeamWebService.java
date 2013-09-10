package com.src.hermes.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.src.hermes.entities.Employee;
import com.src.hermes.entities.Team;
import com.src.hermes.services.TeamEmployeeMapperService;
import com.src.hermes.services.TeamService;

/**
 * Web services for Team entity.
 * 
 * @author Yashaswi Kumar <yashx1@gmail.com>
 */

@Stateless
@Path("team")
@Produces("application/json")
public class TeamWebService {

	private static Logger log = Logger.getLogger(TeamWebService.class);

	@EJB
	private TeamService teamService;

	@EJB
	private TeamEmployeeMapperService mapperService;

	@POST
	public String addTeam(String jsonString) {
		Team team = (new Gson()).fromJson(jsonString, Team.class);
		return teamService.createTeam(team);
	}

	@GET
	public String getTeams() {
		List<Team> teams = teamService.getTeams();
		Gson gson = new Gson();
		return gson.toJson(teams);
	}

	@GET
	@Path("/manage/{teamId}")
	public String getTeamById(@PathParam("teamId") String teamId) {
		Team team = teamService.getTeamById(teamId);
		Gson gson = new Gson();
		return gson.toJson(team);
	}

	@GET
	@Path("/members/{teamId}")
	public String getTeamMembers(@PathParam("teamId") String teamId) {
		List<Employee> teamMembers = mapperService.getTeamMembers(teamId);
		Gson gson = new Gson();
		return gson.toJson(teamMembers);
	}

	@GET
	@Path("/listFreeEmp")
	public String listAvailableEmployees() {
		log.info("inside listAvailableEmployees methode");
		List<Employee> teamMembers = mapperService.listAvailableEmployees();
		Gson gson = new Gson();
		return gson.toJson(teamMembers);
	}

	@POST
	@Path("/{teamId}")
	public String updateTeam(@PathParam("teamId") String teamId, String jsonString) {
		Team team = (new Gson()).fromJson(jsonString, Team.class);
		return teamService.updateTeam(team);
	}

	@DELETE
	@Path("/{teamId}")
	public String deleteTeam(@PathParam("teamId") String teamId) {
		return teamService.deleteTeam(teamId);
	}

	@GET
	@Path("/removeMember/{empId}")
	public boolean removeTeamMember(@PathParam("empId") String empId) {
		return teamService.removeTeamMember(empId);
	}

	@GET
	@Path("/addMember/{teamId}/{empId}")
	public boolean addTeamMember(@PathParam("teamId") String teamId,@PathParam("empId") String empId) {
		return teamService.addTeamMember(teamId, empId);
	}

}
