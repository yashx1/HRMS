package com.src.hermes.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.src.hermes.entities.Employee;
import com.src.hermes.entities.Team;

/*
 * Service class for Team entity.
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */

@Stateless
public class TeamService {
	
	private static Logger log = Logger.getLogger(TeamService.class);
	
	@EJB
	private TeamEmployeeMapperService mapperService;
	
	@PersistenceContext(unitName = "Hermes")
	private EntityManager em;
		
	String msg = "error";
	
	public String createTeam(Team team){
		em.persist(team);
		boolean leadCreated = mapperService.createTeamLead(team);			//creating team lead.
		
		if(leadCreated == true){
			msg = "Team Successfully Created.";
		}
		
		return msg;
	}

	public List<Team> getTeams(){
		List<Team > teams = em.createQuery("SELECT t FROM Team t Order By t.createdOn DESC",Team.class).getResultList();
		
			for(Team team: teams){
				Employee emp = mapperService.getLeader(team.getTeamId());
				team.setTeamLeader(emp.getFname()+" "+emp.getLname()+" ["+emp.getEmpId()+"]");
			}
			
		return teams;
	}
	
	public Team getTeamById(String teamId){
		Team team = em.find(Team.class, teamId);
	
		Employee emp = mapperService.getLeader(team.getTeamId());
		team.setTeamLeader(emp.getFname()+" "+emp.getLname()+" ["+emp.getEmpId()+"]");
	
		return team;
	}
	
	public String updateTeam(Team team){
		em.merge(team);
		msg = "Team record updated successfully.";
		
		return msg;
	}
	
	public String deleteTeam(String teamId){
				
		try{
			Team t = em.find(Team.class, teamId);
			em.remove(t);
			msg = "Team record removed successfully.";
		}catch(Exception e){
			log.info(""+e.getStackTrace());
		}
		
		return msg;
	}

	public boolean removeTeamMember(String empId) {
		return mapperService.removeTeamMember(empId);
	}

	public boolean addTeamMember(String teamId, String empId) {
		return mapperService.addTeamMember(teamId, empId);
	}
}