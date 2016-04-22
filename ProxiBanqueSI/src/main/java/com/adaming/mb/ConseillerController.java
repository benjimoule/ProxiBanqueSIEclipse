package com.adaming.mb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;
import com.adaming.entities.Conseiller;
import com.adaming.service.IserviceConseiller;
import com.adaming.service.ServiceClient;
import com.adaming.service.ServiceConseiller;

@Controller (value = "mbConseiller")
@SessionScoped
public class ConseillerController {
	@Autowired
	private ServiceClient daoclient;

	
	private Conseiller conseillerauthentification;
	private List<Conseiller> listedetouslesconseiller=new ArrayList<Conseiller>();
	private List<Client> listeClientsDuConseiler=new ArrayList<Client>();
	private List<Client> listeDeTousLesClients=new ArrayList<Client>();
	
	
	
	@Autowired
	private IserviceConseiller service; 
	
	private  Conseiller conseillerCourant=new Conseiller();
	
	
	public String authentifier(){
		listedetouslesconseiller=service.getAllConseillers();
		for (Iterator<Conseiller> i = listedetouslesconseiller.iterator(); i.hasNext();) {
            Conseiller item = i.next();
            if (item.getNom().equals(conseillerauthentification.getNom())&& item.getPrenom().equals(conseillerauthentification.getPrenom())) {
                conseillerCourant=item;
                
            }
            
            System.out.println(listedetouslesconseiller.size());
           
            System.out.println(conseillerauthentification.getNom());
            System.out.println(conseillerauthentification.getPrenom());
        }
		
		//choix des clients
		listeDeTousLesClients=daoclient.getAllClients();
		for (Iterator<Client> it = listeDeTousLesClients.iterator(); it.hasNext();) {
            Client item = it.next();
            if (item.getConseiller().getId()==conseillerCourant.getId() ) {
            	listeClientsDuConseiler.add(item);
                
            }
        }
		System.out.println(listeClientsDuConseiler.size());
		System.out.println(conseillerCourant.getNom());
		
		FacesContext context = FacesContext.getCurrentInstance();
	    NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	    navigationHandler.handleNavigation(context, null, "success");
		
			return "success";	
		
		
	}
      




	



	
	







	public ConseillerController() {
		super();
		this.conseillerauthentification= new Conseiller();
	}










	public Conseiller getConseillerCourant() {
		return conseillerCourant;
	}


	public void setConseillerCourant(Conseiller conseillerCourant) {
		this.conseillerCourant = conseillerCourant;
	}





	public List<Conseiller> getListedetouslesconseiller() {
		return listedetouslesconseiller;
	}


	public void setListedetouslesconseiller(
			List<Conseiller> listedetouslesconseiller) {
		this.listedetouslesconseiller = listedetouslesconseiller;
	}






	public Conseiller getConseillerauthentification() {
		return conseillerauthentification;
	}


















	public void setConseillerauthentification(Conseiller conseillerauthentification) {
		this.conseillerauthentification = conseillerauthentification;
	}


















	public List<Client> getListeClientsDuConseiler() {
		return listeClientsDuConseiler;
	}

	public void setListeClientsDuConseiler(List<Client> listeClientsDuConseiler) {
		this.listeClientsDuConseiler = listeClientsDuConseiler;
	}

	public List<Client> getListeDeTousLesClients() {
		return listeDeTousLesClients;
	}

	public void setListeDeTousLesClients(List<Client> listeDeTousLesClients) {
		this.listeDeTousLesClients = listeDeTousLesClients;
	}

	public void setService(ServiceConseiller service) {
		this.service = service;
	};

}
