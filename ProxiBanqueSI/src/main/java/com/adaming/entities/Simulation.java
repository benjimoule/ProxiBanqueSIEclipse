package com.adaming.entities;

public class Simulation {
	private int id;
	private double capital  ;
	private double tauxInteret  ;
	private double duree ;
	private double mensualite;
	private double nombreDePaiements;
	private double coutDuCredit;
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
	public Simulation(double capital, double tauxInteret, double duree,
			double mensualite, double nombreDePaiements) {
		super();
		this.capital = capital;
		this.tauxInteret = tauxInteret;
		this.duree = duree;
		this.mensualite = mensualite;
		this.nombreDePaiements = nombreDePaiements;
	}
	public Simulation() {
		super();
	}
	public double getCoutDuCredit() {
		return coutDuCredit;
	}
	public void setCoutDuCredit(double coutDuCredit) {
		this.coutDuCredit = coutDuCredit;
	}
	public Simulation(double capital, double tauxInteret, double duree,
			double mensualite, double nombreDePaiements, double coutDuCredit) {
		super();
		this.capital = capital;
		this.tauxInteret = tauxInteret;
		this.duree = duree;
		this.mensualite = mensualite;
		this.nombreDePaiements = nombreDePaiements;
		this.coutDuCredit = coutDuCredit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
