package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.adaming.dao.IDaoConseiller;
import com.adaming.entities.Conseiller;
@Service(value = "ServiceConseiller")
public class ServiceConseiller implements IserviceConseiller{
	@Autowired
	private IDaoConseiller daoConseiller;
	
	@Override
	public List<Conseiller> getAllConseillers() {
		
		return daoConseiller.getAllConseillers();
	}

	@Override
	public Conseiller getConseillerById(int id) {
		
		return daoConseiller.getConseillerById(id);
	}

	@Override
	public void addConseiller(Conseiller conseiller) {
		daoConseiller.addConseiller(conseiller);
		
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		daoConseiller.updateConseiller(conseiller);
		
	}

	@Override
	public void deleteConseiller(int id) {
		daoConseiller.deleteConseiller(id);
		
	}

}
