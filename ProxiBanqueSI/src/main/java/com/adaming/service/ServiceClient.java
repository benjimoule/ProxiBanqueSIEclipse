package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;

@Service(value = "ServiceClient")
public class ServiceClient implements IServiceClient {

	@Autowired
	private IDaoClient daoClient;
	
	
	public List<Client> getAllClients() {
		
		return daoClient.getAllClients();
	}

}
