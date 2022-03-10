package com.epf.rentmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.dao.ClientDao;

@Service
public class ClientService {

	private ClientDao clientDao;
	public static ClientService instance;

	private ClientService(ClientDao clientDao) {
		this.clientDao= clientDao;
	}
	
	public long update(Client client) throws ServiceException {
		try {
			return this.clientDao.update(client);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean create(Client client) throws ServiceException {
		try {
			return this.clientDao.create(client);
			
		} catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public Optional<Client> findById(long id) throws ServiceException {
		
		try {
			return this.clientDao.findById(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public long delete(Client client) throws DaoException {
		
		return this.clientDao.delete(client);
	}

	public List<Client> findAll() throws ServiceException {
		// TODO: récupérer tous les clients
		try {
			return this.clientDao.findAll()	;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "ClientService [clientDao=" + clientDao + "]";
	}
	
}
