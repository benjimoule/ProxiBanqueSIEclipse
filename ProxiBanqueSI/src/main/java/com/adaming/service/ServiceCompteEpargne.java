package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IDaoCompteEpargne;
import com.adaming.entities.CompteEpargne;

@Service(value = "ServiceCompteEpargne")
public class ServiceCompteEpargne implements IServiceCompteEpargne {

	@Autowired
	private IDaoCompteEpargne daoCompteEpargne;
	
	
	public List<CompteEpargne> getAllCompteEpargnes() {
		
		return daoCompteEpargne.getAllCompteEpargnes();
	}


	@Override
	public CompteEpargne getCompteEpargneById(int id) {
		return daoCompteEpargne.getCompteEpargneById(id);
	}


	@Override
	public void addCompteEpargne(CompteEpargne compteEpargne) {
		daoCompteEpargne.addCompteEpargne(compteEpargne);
		
	}


	@Override
	public void updateCompteEpargne(CompteEpargne compteEpargne) {
		daoCompteEpargne.updateCompteEpargne(compteEpargne);
		
	}


	@Override
	public void deleteCompteEpargne(int id) {
		daoCompteEpargne.deleteCompteEpargne(id);
		
	}

}
