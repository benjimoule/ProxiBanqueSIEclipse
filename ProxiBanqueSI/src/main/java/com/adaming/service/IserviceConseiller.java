package com.adaming.service;

import java.util.List;


import com.adaming.entities.Conseiller;

public interface IserviceConseiller {
	List<Conseiller> getAllConseillers();
	Conseiller getConseillerById(int id);
	void addConseiller(Conseiller conseiller);
	void updateConseiller(Conseiller conseiller);
	void deleteConseiller(int id);
}
