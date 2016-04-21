package com.adaming.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adaming.entities.Client;

import junit.framework.TestCase;

public class DaoClientTest extends TestCase {

	
	
	private IDaoClient dao;
	
	@Before
	public void setUp(){
		dao = new DaoClient();
	}
	
	@Test
	public void testGetAllClients(){
		List<Client> liste = dao.getAllClients();
		assertEquals(1, liste.size());
	}
}
