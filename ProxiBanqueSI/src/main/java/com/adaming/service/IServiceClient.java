package com.adaming.service;
import java.util.List;

import com.adaming.entities.Client;


public interface IServiceClient {

	public List<Client> getAllClients();
	public Client getClientById(int id);
	public void addClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(int id);
}
