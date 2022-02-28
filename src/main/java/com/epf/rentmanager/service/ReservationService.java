package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;

@Service
public class ReservationService {

	private ReservationDao reservationDao; 
	public static ReservationService instance;
	
	private ReservationService(ReservationDao reservationDao) {
		this.reservationDao=reservationDao;
		
		
	}
	public List<Reservation> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.reservationDao.findAll()	;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
