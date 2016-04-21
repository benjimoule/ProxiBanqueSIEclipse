/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author inti0302
 */
@Entity
@Table(name = "compte_courant")
public class CompteCourant implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte_courant")
    private int id;
    
    @Column(name = "date_ouverture")
    @Temporal(TemporalType.DATE)
    private Date dateOuverture;
    
    @Column(name = "solde")
    private float solde;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Client client;
    
    @Column(name = "decouvert")
    private float decouvert;
    
    @OneToOne(fetch = FetchType.EAGER)
    private CarteBancaire carte;

    public CompteCourant() {
    }

    public CompteCourant(Date dateOuverture, float solde, Client client, float decouvert, CarteBancaire carte) {
        this.dateOuverture = dateOuverture;
        this.solde = solde;
        this.client = client;
        this.decouvert = decouvert;
        this.carte = carte;
    }

    public CompteCourant(int id, Date dateOuverture, float solde, Client client, float decouvert, CarteBancaire carte) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
        this.client = client;
        this.decouvert = decouvert;
        this.carte = carte;
    }

    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }

    public CarteBancaire getCarte() {
        return carte;
    }

    public void setCarte(CarteBancaire carte) {
        this.carte = carte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
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
        final CompteCourant other = (CompteCourant) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
}
