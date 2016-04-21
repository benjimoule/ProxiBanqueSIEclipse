package com.adaming.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author inti0302
 */
@Entity
@Table(name = "agence")
public class Agence implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agence")
    private int id;
    
    @OneToOne(mappedBy = "agence")
    private Gerant gerant;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "code_postal")
    private int codePostal;
    
    @Column(name = "ville")
    private String ville;

    public Agence() {
    }

    public Agence(Gerant gerant, String adresse, int codePostal, String ville) {
        this.gerant = gerant;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Agence(int id, Gerant gerant, String adresse, int codePostal, String ville) {
        this.id = id;
        this.gerant = gerant;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Agence other = (Agence) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
