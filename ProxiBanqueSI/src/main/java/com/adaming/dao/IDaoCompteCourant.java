package com.adaming.dao;

import java.util.List;

import com.adaming.entities.CompteCourant;

public interface IDaoCompteCourant {
	List<CompteCourant> getAllCompteCourants();

	CompteCourant getCompteCourantById(int id);

	void addCompteCourant(CompteCourant compteCourant);

	void updateCompteCourant(CompteCourant compteCourant);

	void deleteCompteCourant(int id);
}
