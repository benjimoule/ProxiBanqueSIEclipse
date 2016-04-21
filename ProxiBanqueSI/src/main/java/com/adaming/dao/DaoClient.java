package com.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Client;

@Repository("DaoClient")
@Transactional
public class DaoClient implements IDaoClient {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	@Override
	public List<Client> getAllClients() {
		
		return getSession().createQuery("From Client").list();
	}


	@Override
	public Client getClientById(int id) {
		
		return (Client) getSession().get(Client.class, id);
	}


	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		
	}

}
