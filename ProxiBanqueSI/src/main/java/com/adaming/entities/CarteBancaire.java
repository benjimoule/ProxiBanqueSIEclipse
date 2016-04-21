/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaming.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author inti0302
 */
@Entity
public class CarteBancaire implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carte")
    private int id;
    
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "date_validite")
    private String dateValidite;
    
    @Column(name = "pictogramme")
    private int pictogramme;
    
    @Column(name = "active")
    private boolean active;

    public CarteBancaire() {
    }

    public CarteBancaire(int numero, String dateValidite, int pictogramme, boolean active) {
        this.numero = numero;
        this.dateValidite = dateValidite;
        this.pictogramme = pictogramme;
        this.active = active;
    }

    public CarteBancaire(int id, int numero, String dateValidite, int pictogramme, boolean active) {
        this.id = id;
        this.numero = numero;
        this.dateValidite = dateValidite;
        this.pictogramme = pictogramme;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(String dateValidite) {
        this.dateValidite = dateValidite;
    }

    public int getPictogramme() {
        return pictogramme;
    }

    public void setPictogramme(int pictogramme) {
        this.pictogramme = pictogramme;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final CarteBancaire other = (CarteBancaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
