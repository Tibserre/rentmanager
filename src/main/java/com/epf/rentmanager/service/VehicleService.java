package com.epf.rentmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.VehicleDao;
@Service
public class VehicleService {

	private VehicleDao vehicleDao;
	public static VehicleService instance;
	
	
	private VehicleService(VehicleDao vehicleDao) {
		this.vehicleDao= vehicleDao;
	}

	
	public boolean create(Vehicle vehicle) throws ServiceException {
	
		try {
			return this.vehicleDao.create(vehicle);
			
		} catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
	}

	public long update(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.update(vehicle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Optional<Vehicle> findById(long id) throws ServiceException {
		try {
			return this.vehicleDao.findById(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public List<Vehicle> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.vehicleDao.findAll()	;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
public long delete(Vehicle vehicle) throws DaoException {
		
		return this.vehicleDao.delete(vehicle);
	}


public int countAll() {
	return this.vehicleDao.countAll();
}
@Override
public String toString() {
	return "VehicleService [vehicleDao=" + vehicleDao + "]";
}
	
}
