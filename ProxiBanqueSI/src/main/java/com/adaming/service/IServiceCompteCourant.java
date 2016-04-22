package com.adaming.service;

import java.util.List;

import com.adaming.entities.CompteCourant;

public interface IServiceCompteCourant {

	public List<CompteCourant> getAllCompteCourants();
	public CompteCourant getCompteCourantById(int id);
	public void addCompteCourant(CompteCourant compteCourant);
	public void updateCompteCourant(CompteCourant compteCourant);
	public void deleteCompteCourant(int id);
}
