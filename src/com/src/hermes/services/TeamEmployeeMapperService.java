package com.src.hermes.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.src.hermes.entities.Employee;
import com.src.hermes.entities.Team;
import com.src.hermes.entities.TeamEmployeeMapper;

/*
 * Service class for TeamEmployeeMapper entity.
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */
@Stateless
public class TeamEmployeeMapperService {

	private static Logger log = Logger.getLogger(TeamEmployeeMapperService.class);
	
	@EJB
	private EmployeeService empService;
	
	@EJB
	private TeamService teamService;
	
	@PersistenceContext(unitName = "Hermes")
	private EntityManager em;
	
	
	String msg = "error";
	
	public boolean createTeamLead(Team team){
		boolean teamLeaderAssigned = false;

		TeamEmployeeMapper mapperObj = new TeamEmployeeMapper();
		mapperObj.setTeam(team);		
		mapperObj.setEmployee(empService.getEmployeeById(team.getTeamLeader()));
		mapperObj.setLeader(true);
		mapperObj.setAssigned(true);
		
		em.persist(mapperObj);	
		
		if(!mapperObj.getMapperId().equals(null)){
			teamLeaderAssigned = true;
		}
		
		return teamLeaderAssigned;
	}

	public Employee getLeader(String teamId) {
		return em.createQuery("SELECT tem FROM TeamEmployeeMapper tem where tem.team.teamId = '" + teamId+"' and tem.isLeader = true", TeamEmployeeMapper.class).getResultList().get(0).getEmployee();
	}

	public List<Employee> getTeamMembers(String teamId) {
		List<Employee> employees = new ArrayList<Employee>();
		
		List<TeamEmployeeMapper> mapperObjs = em.createQuery("SELECT tem FROM TeamEmployeeMapper tem where tem.team.teamId = '" + teamId+"' and tem.isLeader = false", TeamEmployeeMapper.class).getResultList();

		for(TeamEmployeeMapper obj : mapperObjs){
			employees.add(obj.getEmployee());
		}
		return employees;
	}

	public List<Employee> listAvailableEmployees() {
		List<Employee> availableEmployees = em.createQuery("SELECT e FROM Employee e WHERE e.empId NOT IN (select tem.employee.empId from TeamEmployeeMapper tem)", Employee.class).getResultList();
		return availableEmployees;
	}

	public boolean removeTeamMember(String empId) {
		boolean deleted = false;
		
		Query q = em.createQuery("Delete from TeamEmployeeMapper tem where tem.employee.empId ='"+empId+"'");
		int deletedCount = q.executeUpdate();	
		
		log.info("no. of rows deleted:"+deletedCount);
		deleted = true;
						
		return deleted;
	}

	public boolean addTeamMember(String teamId, String empId) {
		
		boolean teamMemberAdded = false;
		
		TeamEmployeeMapper mapperObj = new TeamEmployeeMapper();
		mapperObj.setTeam(teamService.getTeamById(teamId));		
		mapperObj.setEmployee(empService.getEmployeeById(empId));
		mapperObj.setLeader(false);
		mapperObj.setAssigned(true);
		
		em.persist(mapperObj);	
		
		if(!mapperObj.getMapperId().equals(null)){
			teamMemberAdded = true;
		}
		
		return teamMemberAdded;
	}

}
