package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;

import com.epf.rentmanager.model.Reservation;


@Service
public class ReservationService {

	private ReservationDao reservationDao; 
	public static ReservationService instance;
	
	private ReservationService(ReservationDao reservationDao) {
		this.reservationDao=reservationDao;
		
		
	}
	
	public long delete (Reservation reservation) throws DaoException{
		return this.reservationDao.delete(reservation);
	}
	
	public boolean create(Reservation reservation) throws ServiceException {
		
		try {
			return this.reservationDao.create(reservation);
			
		} catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
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
	
	public List<Reservation> findResaByClientId(long clientId) throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.reservationDao.findResaByClientId(clientId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Reservation> findResaByVehicleID(long vehicleId) throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.reservationDao.findResaByVehicleId(vehicleId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
	
