package com.adaming.dao;

import java.util.List;

import com.adaming.entities.CompteEpargne;

public interface IDaoCompteEpargne {

	List<CompteEpargne> getAllCompteEpargnes();

	CompteEpargne getCompteEpargneById(int id);

	void addCompteEpargne(CompteEpargne compteEpargne);

	void updateCompteEpargne(CompteEpargne compteEpargne);

	void deleteCompteEpargne(int id);
}
