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
import com.src.hermes.services.EmployeeService;

/**
 * Web services for Employee entity.
 * @author Yashaswi Kumar <yashx1@gmail.com>
 */

@Stateless
@Path("employee")
@Produces("application/json")
public class EmployeeWebService {

	private static Logger log = Logger.getLogger(EmployeeWebService.class);

	@EJB
	private EmployeeService employeeService;

	@POST
	public String addEmployee(String jsonString) {
		Employee employee = (new Gson()).fromJson(jsonString, Employee.class);
		return employeeService.createEmployee(employee);
	}

	@GET
	public String getEmployees() {
		log.info("inside getEmployees methode");
		List<Employee> employees = employeeService.getEmployees();
		Gson gson = new Gson();
		return gson.toJson(employees);
	}

	@GET
	@Path("/{empId}")
	public String getEmployeeById(@PathParam("empId") String empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		Gson gson = new Gson();
		return gson.toJson(employee);
	}

	@POST
	@Path("/{empId}")
	public String updateEmployee(@PathParam("empId") String empId, String jsonString) {
		Employee employee = (new Gson()).fromJson(jsonString, Employee.class);
		return employeeService.updateEmployee(employee);
	}

	@DELETE
	@Path("/{empId}")
	public String deleteEmployee(@PathParam("empId") String empId) {
		return employeeService.deleteEmployee(empId);
	}

}
