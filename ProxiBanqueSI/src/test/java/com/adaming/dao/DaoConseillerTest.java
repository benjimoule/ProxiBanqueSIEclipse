package com.adaming.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.entities.Conseiller;

public class DaoConseillerTest {
	@Autowired
	private IDaoConseiller daoConseiller;
	
	
//	@Test
//	public void testGetAllConseillers(){
//		List<Conseiller> liste = daoConseiller.getAllConseillers();
//		assertEquals(1, liste.size());
//	}
}
