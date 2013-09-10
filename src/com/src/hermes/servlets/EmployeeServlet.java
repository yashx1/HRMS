package com.src.hermes.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class EmployeeServlet
 * @author Yashaswi Kumar <yashx1@gmail.com>
 */
@WebServlet(urlPatterns = {"/employee/*", "/employees/*"})
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EmployeeServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri[] = request.getRequestURI().split("/");
		
		log.info("requested URI : "+uri[3]);
		
		if(uri[3].equals("create")){
			request.getRequestDispatcher("/createEmployee.view").forward(request, response);
		} else if(uri[3].equals("list")){
			request.getRequestDispatcher("/listEmployees.view").forward(request, response);
		} else{
			request.getRequestDispatcher("/errorPage.view").forward(request, response);
		}
	}

}
