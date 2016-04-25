package com.adaming.mb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.dao.IDaoCompteCourant;
import com.adaming.entities.Client;
import com.adaming.entities.CompteCourant;
import com.adaming.entities.Conseiller;
import com.adaming.entities.Simulation;



@Controller(value = "mbSimulation")
@SessionScoped

public class SimulationController {
	private double capital = 0;
	private double tauxInteret = 4.0/100.0;
	private double duree = 0.0;
	private double mensualite = 0.0;
	private double nombreDePaiements=12.0;
	private double coutDuCredit;
	private List<Simulation> listeDesSimulation= new ArrayList<>();
	private Simulation simulationChoisi=new Simulation();
	private int idSimulationChoisi=0;
	private Client clientSimu =new Client();
	@Autowired
	private IDaoCompteCourant daoCC;
	
	Map<String, Double> tauxInterets;
	@PostConstruct
    public void init() {
		tauxInterets  = new HashMap<String, Double>();
		tauxInterets.put("Prêt Immoblier", 0.04);
		tauxInterets.put("Voiture", 0.07);
		tauxInterets.put("Travaux", 0.055);
		tauxInterets.put("Travaux", 0.085);
	}
	

	public void simulationDeCredit() {
		
	
    
   
		System.out.println("-----simulation de credit----");
		System.out.println("tauxInteret");
		System.out.println(tauxInteret);
		if (mensualite == 0 && duree == 0) {
			System.out.println("simulation a vide");
		} else {
			if (mensualite == 0) {
				mensualite = capital*(tauxInteret/nombreDePaiements)/(1-Math.pow((1+(tauxInteret/nombreDePaiements)),-duree));				
			} else {
				duree=Math.log((-mensualite)/((tauxInteret/nombreDePaiements)*capital-mensualite))/Math.log(1+(tauxInteret/nombreDePaiements));

			}
			coutDuCredit=(mensualite*duree)-capital;
			Simulation simulationCourante = new Simulation();
			System.out.println("duree");
			System.out.println(duree);
			System.out.println("mensualite");
			System.out.println(mensualite);
			simulationCourante.setCapital(capital);
			simulationCourante.setDuree(duree);
			simulationCourante.setMensualite(mensualite);
			simulationCourante.setNombreDePaiements(nombreDePaiements);
			simulationCourante.setTauxInteret(tauxInteret);
			simulationCourante.setCoutDuCredit(coutDuCredit);
			listeDesSimulation.add(simulationCourante);
			System.out.println("nombre de simulation effectué");
			System.out.println(listeDesSimulation.size());
			simulationCourante.setId(listeDesSimulation.size());
		}
	}
	
	public void SoumettreLeCredit(Client client){
		if (idSimulationChoisi==0) {
			System.out.println("soumission a vide");
		}
		else{
		//Choix simu
			System.out.println("idSimulationChoisi");
			System.out.println(idSimulationChoisi);
		for (Iterator<Simulation> i = listeDesSimulation.iterator(); i.hasNext();) {
            Simulation item = i.next();          
            if (item.getId()==idSimulationChoisi) {
            	simulationChoisi=item;               
            }
		
	}
		System.out.println("ClientChoisi");
		System.out.println(client.getNom());
	float presolde=client.getCc().getSolde();
	float predecouvert=client.getCc().getDecouvert();
	CompteCourant compteModifier=client.getCc();
CompteCourant compteApres=new CompteCourant(compteModifier.getId(), compteModifier.getDateOuverture(), presolde+(float)simulationChoisi.getCapital(), 
		compteModifier.getClient(), predecouvert-(float)simulationChoisi.getCapital(), compteModifier.getCarte());
	daoCC.updateCompteCourant(compteApres);
//	client.getCc().setSolde(presolde+(float)simulationChoisi.getCapital());
//	client.getCc().setDecouvert(predecouvert-(float)simulationChoisi.getCapital());
	}}

	public SimulationController() {
		super();
	}

	

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public double getNombreDePaiements() {
		return nombreDePaiements;
	}

	public void setNombreDePaiements(double nombreDePaiements) {
		this.nombreDePaiements = nombreDePaiements;
	}

	public List<Simulation> getListeDesSimulation() {
		return listeDesSimulation;
	}

	public void setListeDesSimulation(List<Simulation> listeDesSimulation) {
		this.listeDesSimulation = listeDesSimulation;
	}

	public double getCoutDuCredit() {
		return coutDuCredit;
	}

	public void setCoutDuCredit(double coutDuCredit) {
		this.coutDuCredit = coutDuCredit;
	}


	public Map<String, Double> getTauxInterets() {
		return tauxInterets;
	}


	public void setTauxInterets(Map<String, Double> tauxInterets) {
		this.tauxInterets = tauxInterets;
	}

	 public void displayLocation() {
	         
	    }


	public Simulation getSimulationChoisi() {
		return simulationChoisi;
	}


	public void setSimulationChoisi(Simulation simulationChoisi) {
		this.simulationChoisi = simulationChoisi;
	}


	public int getIdSimulationChoisi() {
		return idSimulationChoisi;
	}


	public void setIdSimulationChoisi(int idSimulationChoisi) {
		this.idSimulationChoisi = idSimulationChoisi;
	}


	public Client getClientSimu() {
		return clientSimu;
	}


	public void setClientSimu(Client clientSimu) {
		this.clientSimu = clientSimu;
	}


	


}
