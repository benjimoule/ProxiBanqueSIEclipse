package com.adaming.dao;

import java.util.List;

import com.adaming.entities.Client;

public interface IDaoClient {
	List<Client> getAllClients();
	Client getClientById(int id);
	void addClient(Client client);
	void updateClient(Client client);
	void deleteClient(int id);
}
