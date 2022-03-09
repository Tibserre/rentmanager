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
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet(name = "VehicleDetailServlet", urlPatterns = "/cars/details")
public class VehicleDetailServlet extends HttpServlet {

	@Autowired
    private ReservationService reservationService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
    private ClientService clientService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		System.out.println("Servlet vehicle detail OK ");
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		try {
            request.setAttribute("resas",
                    reservationService.findResaByVehicleId(Integer.parseInt(request.getParameter("id"))));
            request.setAttribute("vehicule", Integer.parseInt(request.getParameter("id")));
            request.setAttribute("users", clientService.findAll());
            request.setAttribute("cars", vehicleService.findAll());
        } catch (NumberFormatException | ServiceException e) {
            e.printStackTrace();
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/details.jsp").forward(request,
                response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
