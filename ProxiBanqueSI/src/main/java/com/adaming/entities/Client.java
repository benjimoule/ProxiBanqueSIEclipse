/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaming.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author inti0302
 */
@Entity
@Table(name = "client")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postal")
    private int codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(fetch = FetchType.EAGER)
    private CompteCourant cc;
    
    @OneToOne(fetch = FetchType.EAGER)
    private CompteEpargne ce;
    
    @ManyToOne
    private Conseiller conseiller;
    

    public Client() {
    }

    public Client(int id, String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
    }

    public Client(String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CompteCourant getCc() {
        return cc;
    }

    public void setCc(CompteCourant cc) {
        this.cc = cc;
    }

    public CompteEpargne getCe() {
        return ce;
    }

    public void setCe(CompteEpargne ce) {
        this.ce = ce;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.prenom == null) ? (other.prenom != null) : !this.prenom.equals(other.prenom)) {
            return false;
        }
        if ((this.adresse == null) ? (other.adresse != null) : !this.adresse.equals(other.adresse)) {
            return false;
        }
        if (this.codePostal != other.codePostal) {
            return false;
        }
        if ((this.ville == null) ? (other.ville != null) : !this.ville.equals(other.ville)) {
            return false;
        }
        if ((this.telephone == null) ? (other.telephone != null) : !this.telephone.equals(other.telephone)) {
            return false;
        }
        if (this.cc != other.cc && (this.cc == null || !this.cc.equals(other.cc))) {
            return false;
        }
        if (this.ce != other.ce && (this.ce == null || !this.ce.equals(other.ce))) {
            return false;
        }
        if (this.conseiller != other.conseiller && (this.conseiller == null || !this.conseiller.equals(other.conseiller))) {
            return false;
        }
        return true;
    }

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

    
    
    
}
