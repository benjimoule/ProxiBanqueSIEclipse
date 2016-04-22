package com.adaming.dao;

import java.util.List;

import com.adaming.entities.Conseiller;
import com.adaming.entities.Conseiller;

public interface IDaoConseiller {
	List<Conseiller> getAllConseillers();
	Conseiller getConseillerById(int id);
	void addConseiller(Conseiller conseiller);
	void updateConseiller(Conseiller conseiller);
	void deleteConseiller(int id);
}
