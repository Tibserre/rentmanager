package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet(name = "VehicleCreateServlet", value = "/cars/create")
public class VehicleCreateServlet extends HttpServlet {
	
		@Autowired
	    private VehicleService vehicleService;
	    @Autowired
	    private ClientService clientService;
	
	    @Override
	    public void init() throws ServletException {
	        super.init();
	        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	        System.out.println("Vehicle Create Servlet OK");
	    }
	    
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            request.setAttribute("users", clientService.findAll());
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp").forward(request, response);
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	                Vehicle vehicle = new Vehicle(request.getParameter("manufacturer"),(byte)Integer.parseInt(request.getParameter("seats")));
	                try {
	                    vehicleService.create(vehicle);
	                } catch (ServiceException e) {
	                    e.printStackTrace();
	                }
	        //doGet(request, response);
	        response.sendRedirect("/rentmanager/cars");  
	    }
	    
}
