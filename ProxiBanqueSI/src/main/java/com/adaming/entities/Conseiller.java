/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaming.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author inti0302
 */
@Entity
@Table(name = "conseiller")
public class Conseiller implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conseiller")
    private int id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @ManyToOne(targetEntity = Agence.class)
    private Agence agence;
    
    @ManyToOne(targetEntity = Gerant.class)
    private Gerant gerant;
    
    @OneToMany(mappedBy = "conseiller")
    private List<Client> clients;

    public Conseiller() {
    }

    public Conseiller(String nom, String prenom, Agence agence) {
        this.nom = nom;
        this.prenom = prenom;
        this.agence = agence;
    }

    public Conseiller(int id, String nom, String prenom, Agence agence) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.agence = agence;
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
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
        final Conseiller other = (Conseiller) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
