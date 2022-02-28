package com.epf.rentmanager.dao;
import java.time.LocalDate;
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
public class ClientDao {
	
	private ClientDao() {
	}
	
	//private static ClientDao instance = null;
	
/*	public static ClientDao getInstance() {
		if (instance == null) {
			instance = new ClientDao();
		}
		return instance;
	} */
	
	private static final String CREATE_CLIENT_QUERY = "INSERT INTO Client(nom, prenom, email, naissance) VALUES(?, ?, ?, ?);";
	private static final String DELETE_CLIENT_QUERY = "DELETE FROM Client WHERE id=?;";
	private static final String FIND_CLIENT_QUERY = "SELECT nom, prenom, email, naissance FROM Client WHERE id=?;";
	private static final String FIND_CLIENTS_QUERY = "SELECT id, nom, prenom, email, naissance FROM Client;";
	
	public boolean create(Client client) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_CLIENT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, client.getlastname());
			pstmt.setString(2, client.getName());
			pstmt.setString(3, client.getMail());
			pstmt.setDate(4, Date.valueOf(client.getbirthdate()));
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
	
	public long delete(Client client) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_CLIENT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, client.getId());
			long key = pstmt.executeUpdate();
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public Optional<Client> findById(int id) throws DaoException {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_CLIENT_QUERY);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			String clientLastName = rs.getString("nom");
			String clientFirstName = rs.getString("prenom");
			String clientEmail = rs.getString("email");
			LocalDate clientBirthday = rs.getDate("naissance").toLocalDate();
			
			Client client = new Client (
					 clientFirstName,clientLastName, clientBirthday, clientEmail,id);
			conn.close();
			 if (conn.isClosed()) 
			        System.out.println("Connection closed.");
			return Optional.of(client);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
		
	}

	public List<Client> findAll() throws DaoException {
		
		List<Client> clients = new ArrayList<Client>();
		try {
			
			Connection conn;
			conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_CLIENTS_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Client client = new Client(rs.getString("prenom"), rs.getString("nom"), rs.getDate("naissance").toLocalDate(), rs.getString("email"), rs.getInt("id"));
				clients.add(client);
				conn.close();
				 if (conn.isClosed()) 
				        System.out.println("Connection closed.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return clients;
	}

	

}
