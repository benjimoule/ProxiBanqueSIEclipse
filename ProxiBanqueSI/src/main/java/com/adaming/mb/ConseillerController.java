package com.adaming.mb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.faces.event.ValueChangeEvent;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;




//import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;
import com.adaming.entities.Conseiller;
import com.adaming.service.IServiceCompteCourant;
import com.adaming.service.IServiceCompteEpargne;
import com.adaming.service.IserviceConseiller;
import com.adaming.service.ServiceClient;
import com.adaming.service.ServiceConseiller;

@Controller (value = "mbConseiller")
@SessionScoped
public class ConseillerController {
	@Autowired
	private ServiceClient daoclient;
	@Autowired
	private IserviceConseiller service;
	

	private  Conseiller conseillerCourant=new Conseiller();
	private Conseiller conseillerauthentification =new Conseiller();
	private List<Conseiller> listedetouslesconseiller=new ArrayList<Conseiller>();
	private List<Client> listeClientsDuConseiler=new ArrayList<Client>();
	private List<Client> listeDeTousLesClients=new ArrayList<Client>();
	
	
	
	
	
	
	
	public String authentifier(){
		if(conseillerauthentification.getNom()==null&&conseillerauthentification.getPrenom()==null){
			System.out.println("authentification null");
		}
		else{
		listedetouslesconseiller=service.getAllConseillers();
		for (Iterator<Conseiller> i = listedetouslesconseiller.iterator(); i.hasNext();) {
            Conseiller item = i.next();
            if (item.getNom().equals(conseillerauthentification.getNom())&& item.getPrenom().equals(conseillerauthentification.getPrenom())) {
                conseillerCourant=item;
                
            }

            System.out.println("---- nombre de tous les conseiller---------");            
            System.out.println(listedetouslesconseiller.size());
            System.out.println("---- nom du conseiller---------");
            System.out.println(conseillerauthentification.getNom());
           System.out.println("---- prenom du conseiller---------");
            System.out.println(conseillerauthentification.getPrenom());
        }
		
		
		//choix des clients
		listeDeTousLesClients=daoclient.getAllClients();
		List<Client> listeClientsDuConseilertemporaire=new ArrayList<Client>();
		for (Iterator<Client> it = listeDeTousLesClients.iterator(); it.hasNext();) {
            Client item = it.next();
            if (item.getConseiller().getId()==conseillerCourant.getId() ) {
           	System.out.println("avant l'add");
            	listeClientsDuConseilertemporaire.add(item);
           	System.out.println("apres l'add");
                
            }
        }
		 System.out.println("---- liste des clients du conseiller temporaire---------");
		System.out.println(listeClientsDuConseilertemporaire.size());
		
		//supprimer les clients en double
		List<Client> newList = new ArrayList<Client>(new HashSet<Client>(listeClientsDuConseilertemporaire));
		listeClientsDuConseiler=newList;
		
		System.out.println("---- liste des clients du conseiller---------");
		System.out.println(listeClientsDuConseiler.size());
		
		FacesContext context = FacesContext.getCurrentInstance();
	    NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	    navigationHandler.handleNavigation(context, null, "success");
	   
		}		
		FacesContext context = FacesContext.getCurrentInstance();
	    NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	    navigationHandler.handleNavigation(context, null, "success");
		return "success";
	}
     
	
	

	public ConseillerController() {
		super();
		
	}



	public ConseillerController(ServiceClient daoclient,
			Conseiller conseillerauthentification,
			List<Conseiller> listedetouslesconseiller,
			List<Client> listeClientsDuConseiler,
			List<Client> listeDeTousLesClients, IserviceConseiller service,
			Conseiller conseillerCourant) {
		super();
		this.daoclient = daoclient;
		this.conseillerauthentification = conseillerauthentification;
		this.listedetouslesconseiller = listedetouslesconseiller;
		this.listeClientsDuConseiler = listeClientsDuConseiler;
		this.listeDeTousLesClients = listeDeTousLesClients;
		this.service = service;
		this.conseillerCourant = conseillerCourant;
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
