package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IDaoCompteCourant;
import com.adaming.entities.CompteCourant;

@Service(value = "ServiceCompteCourant")
public class ServiceCompteCourant implements IServiceCompteCourant {

	@Autowired
	private IDaoCompteCourant daoCompteCourant;
	
	
	public List<CompteCourant> getAllCompteCourants() {
		
		return daoCompteCourant.getAllCompteCourants();
	}


	@Override
	public CompteCourant getCompteCourantById(int id) {
		return daoCompteCourant.getCompteCourantById(id);
	}


	@Override
	public void addCompteCourant(CompteCourant compteCourant) {
		daoCompteCourant.addCompteCourant(compteCourant);
		
	}


	@Override
	public void updateCompteCourant(CompteCourant compteCourant) {
		daoCompteCourant.updateCompteCourant(compteCourant);
		
	}


	@Override
	public void deleteCompteCourant(int id) {
		daoCompteCourant.deleteCompteCourant(id);
		
	}

}
