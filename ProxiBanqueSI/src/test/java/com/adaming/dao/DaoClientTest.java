package com.adaming.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adaming.entities.Client;
import com.adaming.entities.CompteCourant;
import com.adaming.entities.CompteEpargne;
import com.adaming.entities.Conseiller;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ( "file:src/main/webapp/WEB-INF/applicationContext.xml"))
public class DaoClientTest extends TestCase {


	@Autowired
	private IDaoClient daoClients;
	

	Client test =new Client("test","test","test", 0000, "test", "test");
	

	
	

	@Test
	public void testGetAllClients(){
		List<Client> liste = daoClients.getAllClients();
		assertEquals(3, liste.size());
	}
	
//	@Test
//	public void testGetClientById(){
//		Client test = daoClients.getClientById(1);
//		assertEquals(test.getNom(), "r");
//	}
	
//	@Test
//	public void testaddClient(){
//		
//		List<Client> liste = daoClients.getAllClients();
//		int taile =liste.size();
//		daoClients.addClient(test);
//		assertEquals(12, taile+1);
//	}
	
//	@Test
//	public void updateClient(){
//		Client updateAvant=new Client();
//		daoClients.addClient(updateAvant);
//		Client updateApres=new Client(updateAvant.getId(), "updateApres","updateApres", "updateApres", 0000, "updateApres", "updateApres");
//		 daoClients.updateClient(updateApres);
//		Client truc= daoClients.getClientById(updateAvant.getId());
//		
//		assertEquals(truc.getNom(), "updateApres");
//	}
//
//	@Test
//	public void testdeleteClient(){
//		
//		List<Client> liste = daoClients.getAllClients();
//		int taille =liste.size();
//		
//		daoClients.deleteClient(13);
//		assertEquals(12, taille-1);
//	}


	
}
