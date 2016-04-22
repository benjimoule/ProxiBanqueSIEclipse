package com.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Client;
import com.adaming.entities.CompteCourant;

@Repository("DaoCompteCourant")
@Transactional
public class DaoCompteCourant implements IDaoCompteCourant {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	@Override
	public List<CompteCourant> getAllCompteCourants() {
		return getSession().createQuery("From CompteCourant").list();
	}

	@Override
	public CompteCourant getCompteCourantById(int id) {
		return (CompteCourant) getSession().get(CompteCourant.class, id);
	}

	@Override
	public void addCompteCourant(CompteCourant compteCourant) {
		getSession().save(compteCourant);

	}

	@Override
	public void updateCompteCourant(CompteCourant compteCourant) {
		getSession().update(compteCourant);

	}

	@Override
	public void deleteCompteCourant(int id) {
		getSession().delete(getCompteCourantById(id));

	}

}
