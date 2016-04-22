package com.adaming.service;

import java.util.List;

import com.adaming.entities.CompteEpargne;

public interface IServiceCompteEpargne {

	public List<CompteEpargne> getAllCompteEpargnes();
	public CompteEpargne getCompteEpargneById(int id);
	public void addCompteEpargne(CompteEpargne compteEpargne);
	public void updateCompteEpargne(CompteEpargne compteEpargne);
	public void deleteCompteEpargne(int id);
}