package com.adaming.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adaming.entities.Client;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ( "file:src/main/webapp/WEB-INF/applicationContext.xml"))
public class DaoClientTest extends TestCase {

	
	@Autowired
	private IDaoClient dao;
	

	@Test
	public void testGetAllClients(){
		List<Client> liste = dao.getAllClients();
		assertEquals(3, liste.size());
	}
}
