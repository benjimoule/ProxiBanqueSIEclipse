package com.adaming.mb;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.entities.CompteCourant;
import com.adaming.entities.CompteEpargne;
import com.adaming.service.IServiceCompteCourant;
import com.adaming.service.IServiceCompteEpargne;

@Controller(value = "mbCompte")
@SessionScoped
public class CompteController {

	@Autowired
	private IServiceCompteCourant serviceCompteCourant;

	@Autowired
	private IServiceCompteEpargne serviceCompteEpargne;

	private List<CompteCourant> listCC;
	private List<CompteEpargne> listCE;

	private CompteCourant emetteurCC;
	private CompteEpargne emetteurCE;
	private CompteCourant destinataireCC;
	private CompteEpargne destinataireCE;
	private boolean choixDestinataire = false;
	private String typeEmetteur = "";
	private String typeDestinataire = "";
	private Float montant;

	public List<CompteCourant> getListCC() {
		listCC = serviceCompteCourant.getAllCompteCourants();
		return listCC;
	}

	public void setListCC(List<CompteCourant> listCC) {

		this.listCC = listCC;
	}

	public List<CompteEpargne> getListCE() {
		listCE = serviceCompteEpargne.getAllCompteEpargnes();
		return listCE;
	}

	public void setListCE(List<CompteEpargne> listCE) {
		this.listCE = listCE;
	}

	public CompteCourant getEmetteurCC() {
		return emetteurCC;
	}

	public void setEmetteurCC(CompteCourant emetteurCC) {
		this.emetteurCC = emetteurCC;
	}

	public CompteEpargne getEmetteurCE() {
		return emetteurCE;
	}

	public void setEmetteurCE(CompteEpargne emetteurCE) {
		this.emetteurCE = emetteurCE;
	}

	public CompteCourant getDestinataireCC() {
		return destinataireCC;
	}

	public void setDestinataireCC(CompteCourant destinataireCC) {
		this.destinataireCC = destinataireCC;
	}

	public CompteEpargne getDestinataireCE() {
		return destinataireCE;
	}

	public void setDestinataireCE(CompteEpargne destinataireCE) {
		this.destinataireCE = destinataireCE;
	}

	public String getTypeEmetteur() {
		return typeEmetteur;
	}

	public void setTypeEmetteur(String typeEmetteur) {
		this.typeEmetteur = typeEmetteur;
	}

	public String getTypeDestinataire() {
		return typeDestinataire;
	}

	public void setTypeDestinataire(String typeDestinataire) {
		this.typeDestinataire = typeDestinataire;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public void choisirCC(int id) {
		if (!choixDestinataire) {
			emetteurCC = serviceCompteCourant.getCompteCourantById(id);
			emetteurCE = null;
			typeEmetteur = "Compte courant";
		} else {
			destinataireCC = serviceCompteCourant.getCompteCourantById(id);
			destinataireCE = null;
			typeDestinataire = "Compte courant";
		}
	}

	public void choisirCE(int id) {
		if (!choixDestinataire) {
			emetteurCE = serviceCompteEpargne.getCompteEpargneById(id);
			emetteurCC = null;
			typeEmetteur = "Compte epargne";
		} else {
			destinataireCE = serviceCompteEpargne.getCompteEpargneById(id);
			destinataireCC = null;
			typeDestinataire = "Compte epargne";
		}
	}

	public void validerEmetteur() {
		if ((emetteurCC != null) || (emetteurCE != null)) {
			choixDestinataire = true;
		}
	}

	public void annulerEmetteur() {
		choixDestinataire = false;
		destinataireCE = null;
		destinataireCC = null;
		typeDestinataire = "";
	}

	public void effectuerVirement() {
		if ((destinataireCC != null) || (destinataireCE != null)) {
			if ((emetteurCC != null) && (!emetteurCC.equals(destinataireCC))) {
				emetteurCC.setSolde(emetteurCC.getSolde() - montant);
				serviceCompteCourant.updateCompteCourant(emetteurCC);
				emetteurCC = null;
				typeEmetteur = "";
			}
			if ((emetteurCE != null) && (!emetteurCE.equals(destinataireCE))) {
				emetteurCE.setSolde(emetteurCE.getSolde() - montant);
				serviceCompteEpargne.updateCompteEpargne(emetteurCE);
				emetteurCE = null;
				typeEmetteur = "";
			}
			if ((destinataireCC != null) && (!destinataireCC.equals(emetteurCC))) {
				destinataireCC.setSolde(destinataireCC.getSolde() + montant);
				serviceCompteCourant.updateCompteCourant(destinataireCC);
				destinataireCC = null;
				typeDestinataire = "";
				choixDestinataire = false;
			}
			if ((destinataireCE != null) && (!destinataireCE.equals(emetteurCE))) {
				destinataireCE.setSolde(destinataireCE.getSolde() + montant);
				serviceCompteEpargne.updateCompteEpargne(destinataireCE);
				destinataireCE = null;
				typeDestinataire = "";
				choixDestinataire = false;
			}
		}

	}
}
