package com.adaming.mb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;
import com.adaming.service.IServiceClient;





@Controller (value = "mbClient")
@SessionScoped
public class ClientController {
	
	
//	@Autowired
//	private IDaoClient daoClient;
	
	@Autowired
	private IServiceClient serviceClient;
		
	private List<Client> list = new ArrayList<Client>();
	
	
	private Client client;
	
	private String nom;
	private String prenom;
	private String telephone;
	

	


	public List<Client> getList() {
		list = serviceClient.getAllClients();
		return list;
	}

	public void setList(List<Client> list) {
		this.list = list;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
