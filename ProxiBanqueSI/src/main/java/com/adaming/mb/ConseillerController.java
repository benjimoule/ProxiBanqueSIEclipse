package com.adaming.mb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.entities.Conseiller;
import com.adaming.service.IserviceConseiller;
import com.adaming.service.ServiceConseiller;

@Controller (value = "mbConseiller")
@SessionScoped
public class ConseillerController {
	
	private String nomAuthentification;
	private String prenomAuthentification;
	private List<Conseiller> listedetouslesconseiller=new ArrayList<Conseiller>();
	
	@Autowired
	private IserviceConseiller service; 
	private  Conseiller conseillerCourant;
	
	
	public Conseiller authentifier(){
		listedetouslesconseiller=service.getAllConseillers();
		for (Iterator<Conseiller> i = listedetouslesconseiller.iterator(); i.hasNext();) {
            Conseiller item = i.next();
            if (item.getNom().equals(nomAuthentification) && item.getPrenom().equals(prenomAuthentification)) {
                conseillerCourant=item;
                
            }
        }
        return conseillerCourant;
		
		
	}



	public ConseillerController(String nomAuthentification,
			String prenomnomAuthentification,
			List<Conseiller> listedetouslesconseiller, ServiceConseiller service) {
		super();
		this.nomAuthentification = nomAuthentification;
		this.prenomAuthentification = prenomnomAuthentification;
		this.listedetouslesconseiller = listedetouslesconseiller;
		
	}


	public ConseillerController() {
		
		super();
	System.out.println("-----------eeeeeeeee--------------");
	}


	public ConseillerController(String nomAuthentification,
			String prenomAuthentification,
			List<Conseiller> listedetouslesconseiller,
			ServiceConseiller service, Conseiller conseillerCourant) {
		super();
		this.nomAuthentification = nomAuthentification;
		this.prenomAuthentification = prenomAuthentification;
		this.listedetouslesconseiller = listedetouslesconseiller;
		
		this.conseillerCourant = conseillerCourant;
	}


	public String getPrenomAuthentification() {
		return prenomAuthentification;
	}


	public void setPrenomAuthentification(String prenomAuthentification) {
		this.prenomAuthentification = prenomAuthentification;
	}


	public Conseiller getConseillerCourant() {
		return conseillerCourant;
	}


	public void setConseillerCourant(Conseiller conseillerCourant) {
		this.conseillerCourant = conseillerCourant;
	}


	public String getNomAuthentification() {
		return nomAuthentification;
	}


	public void setNomAuthentification(String nomAuthentification) {
		this.nomAuthentification = nomAuthentification;
	}


	public String getPrenomnomAuthentification() {
		return prenomAuthentification;
	}


	public void setPrenomnomAuthentification(String prenomnomAuthentification) {
		this.prenomAuthentification = prenomnomAuthentification;
	}


	public List<Conseiller> getListedetouslesconseiller() {
		return listedetouslesconseiller;
	}


	public void setListedetouslesconseiller(
			List<Conseiller> listedetouslesconseiller) {
		this.listedetouslesconseiller = listedetouslesconseiller;
	}




	public void setService(ServiceConseiller service) {
		this.service = service;
	};

}
