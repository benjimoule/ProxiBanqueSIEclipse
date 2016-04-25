package com.adaming.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.entities.CompteCourant;

public class DaoCompteCourantTest {
	@Autowired
	private IDaoCompteCourant daoCompteCourant;
	
//	@Test
//	public void testGetAllComptesCourants(){
//		List<CompteCourant> liste = daoCompteCourant.getAllCompteCourants();
//		assertEquals(2, liste.size());
//	}
}
