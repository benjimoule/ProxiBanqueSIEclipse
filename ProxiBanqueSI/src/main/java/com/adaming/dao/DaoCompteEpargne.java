package com.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.CompteEpargne;

@Repository("DaoCompteEpargne")
@Transactional
public class DaoCompteEpargne implements IDaoCompteEpargne {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	@Override
	public List<CompteEpargne> getAllCompteEpargnes() {
		return getSession().createQuery("From CompteEpargne").list();
	}

	@Override
	public CompteEpargne getCompteEpargneById(int id) {
		return (CompteEpargne) getSession().get(CompteEpargne.class, id);
	}

	@Override
	public void addCompteEpargne(CompteEpargne compteEpargne) {
		getSession().save(compteEpargne);

	}

	@Override
	public void updateCompteEpargne(CompteEpargne compteEpargne) {
		getSession().update(compteEpargne);

	}

	@Override
	public void deleteCompteEpargne(int id) {
		getSession().delete(getCompteEpargneById(id));

	}

}
