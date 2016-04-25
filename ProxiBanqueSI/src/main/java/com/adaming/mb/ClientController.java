package com.adaming.mb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.adaming.dao.IDaoClient;
import com.adaming.dao.IDaoConseiller;
import com.adaming.entities.CarteBancaire;
import com.adaming.entities.Client;
import com.adaming.entities.CompteCourant;
import com.adaming.entities.CompteEpargne;
import com.adaming.entities.Conseiller;
import com.adaming.service.IServiceCarteBancaire;
import com.adaming.service.IServiceClient;
import com.adaming.service.IServiceCompteCourant;
import com.adaming.service.IServiceCompteEpargne;

@Controller(value = "mbClient")
@SessionScoped
@Transactional
public class ClientController {

	// @Autowired
	// private IDaoClient daoClient;

	@Autowired
	private IServiceClient serviceClient;

	@Autowired
	private IServiceCompteCourant serviceCC;

	@Autowired
	private IServiceCompteEpargne serviceCE;
	
	@Autowired
	private IServiceCarteBancaire serviceCB;
	
	
	//private ConseillerController conseilContr;

	private List<Client> list = new ArrayList<Client>();
	private List<Client> auditList;
	private List<Client> listeClientDuConseiler = new ArrayList<Client>();
	private Client client;

	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private Client client1;
	private Integer idASupprimer;
	
	private String ccDateOuverture;
    private float ccSolde;
    private float ccDecouvert;
    
    private String ceDateOuverture;
    private float ceSolde;
    private float ceTaux;
    
    private int cbNumero;
    private String cbDateValidite;
    private int cbPictogramme;
    private boolean cbActive;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");


	public String RedirectionVirement() {

		System.out.println("redirection virement");
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler navigationHandler = context.getApplication()
				.getNavigationHandler();
		navigationHandler.handleNavigation(context, null, "virement");
		return "virement";
	}

	public String Redirection() {

		System.out.println("redirection simulation");
		FacesContext context = FacesContext.getCurrentInstance();
		NavigationHandler navigationHandler = context.getApplication()
				.getNavigationHandler();
		navigationHandler.handleNavigation(context, null, "simulation");
		return "simulation";
	}

	public boolean ClientEstRiche(int id) {
		Client clientTeste = serviceClient.getClientById(id);

		// recuperer les comptes Courants du clients
		List<CompteCourant> listeDeTousLesComptesCourants = serviceCC
				.getAllCompteCourants();
		List<CompteCourant> listeComptesCourantsDuClients = new ArrayList<>();

		for (Iterator<CompteCourant> it = listeDeTousLesComptesCourants
				.iterator(); it.hasNext();) {
			CompteCourant item = it.next();
			if (item.getClient().getId() == clientTeste.getId()) {
				listeComptesCourantsDuClients.add(item);

			}
		}

		List<CompteEpargne> listeDeTousLesComptesEpargnes = serviceCE
				.getAllCompteEpargnes();
		List<CompteEpargne> listeComptesEpargnesDuClients = new ArrayList<>();

		for (Iterator<CompteEpargne> i = listeDeTousLesComptesEpargnes
				.iterator(); i.hasNext();) {
			CompteEpargne item = i.next();
			if (item.getClient().getId() == clientTeste.getId()) {
				listeComptesEpargnesDuClients.add(item);
			}
		}

		// test somme des comptes
		float sommesDesComptesEpargnesDuClients = 0;

		for (Iterator<CompteEpargne> i = listeComptesEpargnesDuClients
				.iterator(); i.hasNext();) {
			CompteEpargne item = i.next();
			sommesDesComptesEpargnesDuClients = sommesDesComptesEpargnesDuClients
					+ item.getSolde();
		}

		float sommesDesComptesCourantsDuClients = 0;
		for (Iterator<CompteCourant> i = listeComptesCourantsDuClients
				.iterator(); i.hasNext();) {
			CompteCourant item = i.next();
			sommesDesComptesCourantsDuClients = sommesDesComptesCourantsDuClients
					+ item.getSolde();
		}

		float sommesDesComptesDuClients = sommesDesComptesCourantsDuClients
				+ sommesDesComptesEpargnesDuClients;

		if (sommesDesComptesDuClients > 500000) {
			clientTeste.setEstRiche(true);
		} else {
			clientTeste.setEstRiche(false);
		}

		return clientTeste.isEstRiche();
	}

	public ClientController() {
		super();

	}

	public List<Client> getList() {

		list = serviceClient.getAllClients();
		return list;
	}

	public void setList(List<Client> list) {
		this.list = list;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient1() {
		client1 = serviceClient.getClientById(1);
		return client1;
	}

	public void setClient1(Client client1) {
		this.client1 = client1;
	}

	public List<Client> getListeClientDuConseiler() {
		return listeClientDuConseiler;
	}

	public void setListeClientDuConseiler(List<Client> listeClientDuConseiler) {
		this.listeClientDuConseiler = listeClientDuConseiler;
	}
	
	

	public List<Client> getAuditList() {
		return auditList;
	}

	public void setAuditList(List<Client> auditList) {
		this.auditList = auditList;
	}
	
	

	public String getCcDateOuverture() {
		return ccDateOuverture;
	}

	public void setCcDateOuverture(String ccDateOuverture) {
		this.ccDateOuverture = ccDateOuverture;
	}

	public float getCcSolde() {
		return ccSolde;
	}

	public void setCcSolde(float ccSolde) {
		this.ccSolde = ccSolde;
	}

	public float getCcDecouvert() {
		return ccDecouvert;
	}

	public void setCcDecouvert(float ccDecouvert) {
		this.ccDecouvert = ccDecouvert;
	}

	public String getCeDateOuverture() {
		return ceDateOuverture;
	}

	public void setCeDateOuverture(String ceDateOuverture) {
		this.ceDateOuverture = ceDateOuverture;
	}

	public float getCeSolde() {
		return ceSolde;
	}

	public void setCeSolde(float ceSolde) {
		this.ceSolde = ceSolde;
	}

	public float getCeTaux() {
		return ceTaux;
	}

	public void setCeTaux(float ceTaux) {
		this.ceTaux = ceTaux;
	}

	public int getCbNumero() {
		return cbNumero;
	}

	public void setCbNumero(int cbNumero) {
		this.cbNumero = cbNumero;
	}

	public String getCbDateValidite() {
		return cbDateValidite;
	}

	public void setCbDateValidite(String cbDateValidite) {
		this.cbDateValidite = cbDateValidite;
	}

	public int getCbPictogramme() {
		return cbPictogramme;
	}

	public void setCbPictogramme(int cbPictogramme) {
		this.cbPictogramme = cbPictogramme;
	}

	public boolean isCbActive() {
		return cbActive;
	}

	public void setCbActive(boolean cbActive) {
		this.cbActive = cbActive;
	}

	public void addClient() throws ParseException {
		client = new Client(nom, prenom, adresse, codePostal, ville, telephone);
		//Conseiller conseilCourant = conseilContr.getConseillerCourant();
		//client.setConseiller(conseilCourant);
		serviceClient.addClient(client);
		
		CarteBancaire cb = new CarteBancaire(cbNumero, cbDateValidite, cbPictogramme, cbActive);
		serviceCB.addCarteBancaire(cb);
		
		CompteCourant cc = new CompteCourant(sdf.parse(ccDateOuverture), ccSolde, client, ccDecouvert, cb);
		serviceCC.addCompteCourant(cc);
		client.setCc(cc);
		
		CompteEpargne ce = new CompteEpargne(sdf.parse(ceDateOuverture), ceSolde, client, ceTaux);
		serviceCE.addCompteEpargne(ce);
		client.setCe(ce);
		
		serviceClient.updateClient(client);
		
	}

	public void choisirIdASupprimer(int idCourant) {
		idASupprimer = idCourant;
		Client clientTemp = serviceClient.getClientById(idCourant);
		nom = clientTemp.getNom();
		prenom = clientTemp.getPrenom();
		adresse = clientTemp.getAdresse();
		codePostal = clientTemp.getCodePostal();
		ville = clientTemp.getVille();
		telephone = clientTemp.getTelephone();
	}

	public void deleteClient() {
		if ((idASupprimer != null)
				&& (serviceClient.getClientById(idASupprimer) != null)) {
			serviceClient.deleteClient(idASupprimer);
		}
	}

	public void updateClient() {
		if ((idASupprimer != null)
				&& (serviceClient.getClientById(idASupprimer) != null)) {
			serviceClient.updateClient(new Client(idASupprimer, nom, prenom,
					adresse, codePostal, ville, telephone));
		}

	}

	public boolean testRiche() {

		return false;
	}

	public void auditer() {
		List<Client> allClients = getList();
		auditList = new ArrayList<>();

		for (Iterator<Client> it = allClients.iterator(); it.hasNext();) {
			Client item = it.next();
			if ((item.getCc().getSolde() < -5000)
					|| (item.getCe().getSolde() < -5000)) {
				auditList.add(item);

			}
		}

		
	}
}
