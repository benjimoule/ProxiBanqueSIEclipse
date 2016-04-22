package com.adaming.mb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.dao.IDaoClient;
import com.adaming.dao.IDaoConseiller;
import com.adaming.entities.Client;
import com.adaming.entities.Conseiller;
import com.adaming.service.IServiceClient;

@Controller(value = "mbClient")
@SessionScoped
public class ClientController {

	// @Autowired
	// private IDaoClient daoClient;

	@Autowired
	private IServiceClient serviceClient;
	

	private List<Client> list = new ArrayList<Client>();
	private List<Client>listeClientDuConseiler = new ArrayList<Client>();
	private Client client;

	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private Client client1;
	private Integer idASupprimer;
	

	public ClientController() {
		super();

	}

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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

	public Client getClient1() {
		client1 = serviceClient.getClientById(1);
		return client1;
	}

	public void setClient1(Client client1) {
		this.client1 = client1;
	}

	public List<Client> getListeClientDuConseiler() {
		return listeClientDuConseiler;
	}

	public void setListeClientDuConseiler(List<Client> listeClientDuConseiler) {
		this.listeClientDuConseiler = listeClientDuConseiler;
	}

	public void addClient() {
		client = new Client(nom, prenom, adresse, codePostal, ville, telephone);
		serviceClient.addClient(client);
	}

	public void choisirIdASupprimer(int idCourant) {
		idASupprimer = idCourant;
		Client clientTemp = serviceClient.getClientById(idCourant);
		nom = clientTemp.getNom();
		prenom = clientTemp.getPrenom();
		adresse = clientTemp.getAdresse();
		codePostal = clientTemp.getCodePostal();
		ville = clientTemp.getVille();
		telephone = clientTemp.getTelephone();
	}

	public void deleteClient() {
		if ((idASupprimer != null) && (serviceClient.getClientById(idASupprimer) != null)) {
			serviceClient.deleteClient(idASupprimer);
		}
	}
	
	public void updateClient(){
		if((idASupprimer != null) && (serviceClient.getClientById(idASupprimer) != null)){
			serviceClient.updateClient(new Client(idASupprimer, nom, prenom, adresse, codePostal, ville, telephone));
		}
		
	}

	public boolean testRiche(){
		
		
		return false;
	}
}
