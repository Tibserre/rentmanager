
package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet(name = "VehicleUpdateServlet", value = "/cars/update")
public class VehicleUpdateServlet extends HttpServlet {
   
    @Autowired
    private VehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("My servlet has been initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("vehicule", vehicleService.findById(Long.parseLong(request.getParameter("id"))).get());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Vehicle vehicle = new Vehicle(Long.parseLong(request.getParameter("id")),
                                                request.getParameter("manufacturer"),
                                                (byte)Integer.parseInt(request.getParameter("seats")));
                try {
                    vehicleService.update(vehicle);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
        //doGet(request, response);
        response.sendRedirect("/rentmanager/cars");  
    }
}
