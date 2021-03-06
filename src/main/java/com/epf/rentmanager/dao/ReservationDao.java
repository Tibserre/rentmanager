package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class ReservationDao {
	
	private ReservationDao() {
		
	}
	
	
	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATION_BY_ID_QUERY = "SELECT client_id, vehicle_id, debut, fin FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String FIND_RESERVATION_VEHICLE_BY_CLIENT_ID_QUERY = "SELECT DISTINCT Vehicle.id, Vehicle.constructeur, Vehicle.nb_places FROM Reservation INNER JOIN Vehicle ON Reservation.vehicle_id = Vehicle.id WHERE client_id=?;";	
	private static final String COUNT_RESERVATION_QUERY = "SELECT COUNT (*) FROM Reservation;";
	
	
	public int countAll() {
		int count = 0;
		
		Connection conn;
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(COUNT_RESERVATION_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) { // just in case
			    count = rs.getInt(1); // note that indexes are one-based
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}

	
	
	public List<Vehicle> findResaVehicleByClientId(long clientId) throws DaoException {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
try {
			
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATION_VEHICLE_BY_CLIENT_ID_QUERY);
			pstmt.setLong(1, clientId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Vehicle vehicle = new Vehicle ( rs.getLong("id"), rs.getString("constructeur"), rs.getInt("nb_places") );
				vehicles.add(vehicle);
				
			}
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return vehicles;
	}
	
	
	
	public boolean create(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_RESERVATION_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, reservation.getClient_id());
			pstmt.setLong(2, reservation.getVehicle_id());
			pstmt.setDate(3, Date.valueOf(reservation.getStart_resa()));
			pstmt.setDate(4, Date.valueOf(reservation.getEnd_resa()));
			pstmt.executeUpdate();
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	return true;
	}
		
	
	public long delete(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_RESERVATION_QUERY, 
															PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, reservation.getId());
			long key = pstmt.executeUpdate();
			System.out.println(reservation.getId());
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
			return key;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Reservation> findResaById(long id) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATION_BY_ID_QUERY);
			
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			Long reservationClientId = rs.getLong("client_id");
			Long reservationVehicleId = rs.getLong("vehicle_id");
			LocalDate reservationDebut = rs.getDate("debut").toLocalDate();
			LocalDate reservationFin = rs.getDate("fin").toLocalDate();
			
			
			Reservation reservation = new Reservation (
					 id,reservationDebut, reservationFin, reservationClientId,reservationVehicleId);
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
			return Optional.of(reservation);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public List<Reservation> findResaByClientId(long clientId) throws DaoException {
		
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			pstmt.setLong(1, clientId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reservation reservation = new Reservation ( rs.getLong("id"), rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate(), (long)(clientId), rs.getLong("vehicle_id") );
				reservations.add(reservation);
				
			}
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return reservations;
	}
	
	public List<Reservation> findResaByVehicleId(long vehicleId) throws DaoException {
		List<Reservation> reservations = new ArrayList<Reservation>();
		
try {
			
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_VEHICLE_QUERY);
			pstmt.setLong(1, vehicleId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reservation reservation = new Reservation ( rs.getLong("id"), rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate(), rs.getLong("client_id"), vehicleId );
				reservations.add(reservation);
				
			}
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return reservations;
	}

	public List<Reservation> findAll() throws DaoException {
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reservation reservation = new Reservation(rs.getLong("id"), rs.getDate("debut").toLocalDate(), rs.getDate("fin").toLocalDate(), rs.getLong("client_id"), rs.getLong("vehicle_id"));
				reservations.add(reservation);
			}
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reservations; 
	}
}
