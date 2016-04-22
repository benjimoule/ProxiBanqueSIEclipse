package com.adaming.main;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.adaming.dao.DaoClient;
import com.adaming.dao.IDaoClient;
import com.adaming.entities.Client;
import com.adaming.service.IServiceClient;
import com.adaming.service.ServiceClient;

public class Main {
//	public static void main(String[] args) {
//        ApplicationContext context = 
//            new ClassPathXmlApplicationContext("META-INF/config.xml");
//
//        Main p = context.getBean(Main.class);
//        p.start(args);
//    }
	
	
//	public static void main(String[] args) {
//		
//		IServiceClient serviceClient = new ServiceClient();
//
//		
//	//	ApplicationContext context = 
//		//            new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");
//
//		Client client = serviceClient.
//		System.out.println();
//
//	}
	
	public static void main(String[] args) {

		/**
		 * Test du DAO Compte Courant
		 **/

		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		IServiceClient serviceClient = (IServiceClient) ctx.getBean("ServiceClient");
		Client client = serviceClient.getClientById(1);
		
		System.out.println(client.getNom());
		System.out.println(client.getPrenom());
		// IDaoCompteCourant ccDao = (IDaoCompteCourant)
		// ctx.getBean("daoCompteCourant");
		// List<CompteCourant> comptesCourants = new ArrayList<CompteCourant>();

		// Get All comptes courants + affichage console
		// comptesCourants = ccDao.getAll();
		// for (CompteCourant cc : comptesCourants) {
		// System.out.println(cc.getId() + cc.getDateOuverture() +
		// cc.getNumero() + cc.getSolde() + cc.getDecouvert());
		// }

		// Get Compte Courant by Id + affichage console
		// CompteCourant ccId = ccDao.getById(2);
		// System.out.println("Compte Courant get By Id : " + ccId.getId() +
		// ccId.getDateOuverture() + ccId.getNumero()
		// + ccId.getSolde() + ccId.getDecouvert());

		// Ajout d'un compte courant
		// CompteCourant ccAdd = new CompteCourant("0123456789", 2000.0, 5000.0,
		// "LE CHOIX DANS LA DATE");
		// ccDao.add(ccAdd);

		// Suppression d'un compte courant
		// ccDao.deleteById(6);

		// Modification d'un compte courant
		// CompteCourant ccToUpdate = ccDao.getById(5);
		// ccToUpdate.setDateOuverture("La bonne date pleine de swag");
		// ccDao.update(ccToUpdate);

	}


}
