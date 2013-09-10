package com.src.hermes.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.src.hermes.entities.Employee;

/*
 * Service class for Employee entity.
 * @author : Yashaswi Kumar <yashx1@gmail.com>
 */

@Stateless
public class EmployeeService {
	private static Logger log = Logger.getLogger(EmployeeService.class);
	
	@PersistenceContext(unitName = "Hermes")
	private EntityManager em;
	
	String msg = "error";
	
	public String createEmployee(Employee employee){
		em.persist(employee);
		if(!employee.getEmpId().equals(null)){
			msg = "Employee Successfully Created.";
		}
		return msg;
	}

	public List<Employee> getEmployees(){
		return em.createQuery("SELECT e FROM Employee e Order By e.createdOn DESC",Employee.class).getResultList();
	}
	
	public Employee getEmployeeById(String empId){
		log.info("inside getEmployeeById methode");
		List<Employee> list = em.createQuery("SELECT e FROM Employee e where e.empId = '" + empId +"'", Employee.class).getResultList();
		return list.get(0);
	}
	
	public String updateEmployee(Employee employee){
		em.merge(employee);
		msg = "Employee record updated successfully.";
		return msg;
	}
	
	public String deleteEmployee(String empId){
		try{
			Employee e = em.find(Employee.class, empId);
			em.remove(e);
			msg = "Employee record removed successfully.";
		}catch(Exception e){
			log.info(""+e.getStackTrace());
		}
		return msg;
	}
}