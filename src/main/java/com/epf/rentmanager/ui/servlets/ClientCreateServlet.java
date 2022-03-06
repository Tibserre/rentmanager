package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.server.ServerErrorException;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet(name = "UserCreateServlet", urlPatterns = "/users/create")
public class ClientCreateServlet extends HttpServlet {
	

	@Autowired
	ClientService clientService;
	@Override
	public void init() throws ServletException {
	super.init();
	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	System.out.println("Servlet Client Create OK");
	}
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
             System.out.println(request.getParameter("birthdate"));
             Client client = new Client(request.getParameter("last_name"),request.getParameter("first_name"),LocalDate.parse(request.getParameter("birthdate"),formatter), request.getParameter("email"));
             System.out.println(client);
             try {
                 clientService.create(client);
             } catch (ServerErrorException | ServiceException e) {
                 e.printStackTrace();
             }
    	response.sendRedirect("/rentmanager/users");  
    }
}