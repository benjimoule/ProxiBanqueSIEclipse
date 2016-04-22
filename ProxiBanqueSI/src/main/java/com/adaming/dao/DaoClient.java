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
	
	
	public List<Client> getAllClients() {
		
		return getSession().createQuery("From Client").list();
	}



	public Client getClientById(int id) {
		
		return (Client) getSession().get(Client.class, id);
	}



	public void addClient(Client client) {
		getSession().save(client);
		
	}



	public void updateClient(Client client) {
		getSession().update(client);
		
	}


	public void deleteClient(int id) {
		getSession().delete(getClientById(id));
		
	}

}
