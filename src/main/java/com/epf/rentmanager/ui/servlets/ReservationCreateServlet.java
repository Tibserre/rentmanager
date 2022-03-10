package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name = "ReservationCreateServlet", urlPatterns = "/rents/create")
public class ReservationCreateServlet extends HttpServlet {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ReservationService reservationService;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("Resea create servlet OK");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            	List<Vehicle> vehicles = vehicleService.findAll();
            	List<Client> clients = clientService.findAll();
            request.setAttribute("vehicules", vehicles);
            request.setAttribute("clients", clients);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("WALAA");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                Reservation reservation = new Reservation(
                		LocalDate.parse(request.getParameter("begin"), formatter),
                        LocalDate.parse(request.getParameter("end"), formatter), 
                        Long.parseLong(request.getParameter("client")),
                        Long.parseLong(request.getParameter("car")));
                
                		 
                try {
                    reservationService.create(reservation);
                } catch (ServiceException e) {
                	System.out.println("WALAA");
                    e.printStackTrace();
                }
        //doGet(request, response);
                System.out.println("Nique la bac");
                response.sendRedirect("/rentmanager/rents");
    }
}