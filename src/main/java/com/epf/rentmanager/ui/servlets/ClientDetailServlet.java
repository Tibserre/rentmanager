package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;


@WebServlet(name = "ClientDetailServlet", urlPatterns = "/users/details")
public class ClientDetailServlet extends HttpServlet {
	 @Autowired
	    private ClientService clientService;
	 
	 @Autowired
	    private ReservationService reservationService;
	 
	 @Autowired
	    private VehicleService vehicleService;
	
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	        System.out.println("Servlet Client Detail OK");
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            long id = Long.parseLong(request.getParameter("id"));

	            request.setAttribute("user", clientService.findById(id).get());
	           
	            request.setAttribute("reservations", reservationService.findResaByClientId(id));
	           request.setAttribute("cars", vehicleService.findAll());
	           request.setAttribute("vehicules", reservationService.findResaVehicleByClientId(id));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	        request.getServletContext().getRequestDispatcher("/WEB-INF/views/users/details.jsp").forward(request, response);
	    }
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
