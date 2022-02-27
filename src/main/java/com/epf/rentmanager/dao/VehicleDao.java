package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class VehicleDao {
	
	private VehicleDao() {
	}
	private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicle(constructeur, nb_places) VALUES(?, ?);";
	private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLE_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle WHERE id=?;";
	private static final String FIND_VEHICLES_QUERY = "SELECT id, constructeur, nb_places FROM Vehicle;";
	
	public boolean create(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_VEHICLE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, vehicle.getConstructeur());
			pstmt.setInt(2, vehicle.getNb_places());
			pstmt.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public long delete(Vehicle vehicle) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_VEHICLE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, vehicle.getId());
			long key = pstmt.executeUpdate();
			
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Vehicle> findById(long id) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLE_QUERY);
			
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			String vehicleConstructeur = rs.getString("constructeur");
			int vehicleNb_places = rs.getInt("nb_places");
			Vehicle vehicle = new Vehicle (id, vehicleConstructeur, vehicleNb_places );
			conn.close();
			return Optional.of(vehicle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
		
	}

	public List<Vehicle> findAll() throws DaoException {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_VEHICLES_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vehicle vehicle = new Vehicle( rs.getLong("id"), rs.getString("constructeur"), rs.getInt("nb_places"));
				vehicles.add(vehicle);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return vehicles;
	}
	
	

}
