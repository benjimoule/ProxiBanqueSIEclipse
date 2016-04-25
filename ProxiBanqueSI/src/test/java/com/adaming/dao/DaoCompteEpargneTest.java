package com.adaming.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.entities.CompteEpargne;

public class DaoCompteEpargneTest {
	@Autowired
	private IDaoCompteEpargne daoCompteEpargne;

//	@Test
//	public void testGetAllComptesEpargnes(){
//		List<CompteEpargne> liste = daoCompteEpargne.getAllCompteEpargnes();
//		assertEquals(2, liste.size());
//	}
}