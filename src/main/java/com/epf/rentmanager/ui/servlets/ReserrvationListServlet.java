package com.epf.rentmanager.ui.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ReservationService;

@WebServlet(name = "ReservationListServlet", urlPatterns = "/rents")

public class ReserrvationListServlet extends HttpServlet {

	@Autowired
    private ReservationService reservationService;
	
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	        System.out.println("Resa List Servlet OK");
	    }
	
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            List<Reservation> resas = reservationService.findAll();
	            request.setAttribute("resas", resas);
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	        request.getRequestDispatcher("./WEB-INF/views/rents/list.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
}
