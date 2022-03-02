package com.EPF.rentmanager;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public AppTest() {
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    public boolean testClient(){
    	
    	
    	return true;
    }
    
public boolean testReservation() throws DaoException{
		if(this.testReservationCreate() == true && 
				this.testReservationDelete() == true) {
			return true;
		}else return false;
    }


public boolean testReservationCreate() {
	ApplicationContext context = new
			AnnotationConfigApplicationContext(AppConfiguration.class);
			ReservationService reservationService = context.getBean(ReservationService.class);
			ClientService clientService = context.getBean(ClientService.class);
			VehicleService vehicleService = context.getBean(VehicleService.class);
			
			try (Scanner sc = new Scanner(System.in)){
				
			System.out.println(clientService.findAll());
			System.out.println(vehicleService.findAll());
			System.out.println(reservationService.findAll());
			
			System.out.println("ID Client");
			long IdClient = sc.nextLong();
			System.out.println("ID Vehicle");
			long IdVehicle = sc.nextLong();
			System.out.println("Date Début JJ/MM/YYYY");
			String debut = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate dDebut = LocalDate.parse(debut, formatter);
			System.out.println("Date Fin JJ/MM/YYYY");
			String fin = sc.next();
			LocalDate dFin = LocalDate.parse(fin, formatter);
			Reservation reservation = new Reservation (dDebut, dFin, IdClient, IdVehicle );
			System.out.println(reservationService.create(reservation));
			} catch (ServiceException e) {
			
				e.printStackTrace();
				return false; 
			}
	
	return true;
}


public boolean testReservationDelete() {
	
	try (Scanner sc = new Scanner(System.in)) {
		ApplicationContext context = new
				AnnotationConfigApplicationContext(AppConfiguration.class);
				ReservationService reservationService = context.getBean(ReservationService.class);
		
		System.out.println(reservationService.findAll());
		
		System.out.println("ID à suppr ");
		long Id = sc.nextLong();
		Reservation reservationSuppr = new Reservation (Id);
		System.out.println(reservationService.delete(reservationSuppr));
	} catch (ServiceException e) {
		e.printStackTrace();
		return false;
	} catch (DaoException e) {
		e.printStackTrace();
		return false;
	}
	
	return true;
}



public boolean testVehicle(){
	
	
	return true;
}
    
}
