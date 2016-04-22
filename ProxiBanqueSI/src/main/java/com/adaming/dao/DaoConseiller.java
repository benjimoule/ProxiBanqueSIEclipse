package com.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Client;
import com.adaming.entities.Conseiller;
@Repository("DaoConseiller")
@Transactional
public class DaoConseiller implements IDaoConseiller{

	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	@Override
	public List<Conseiller> getAllConseillers() {
		
		return getSession().createQuery("From Conseiller").list();
	}
	@Override
	public Conseiller getConseillerById(int id) {
		return (Conseiller) getSession().get(Conseiller.class, id);
	}
	@Override
	public void addConseiller(Conseiller conseiller) {
		getSession().save(conseiller);
		
	}
	@Override
	public void updateConseiller(Conseiller conseiller) {
		getSession().update(conseiller);
		
	}
	@Override
	public void deleteConseiller(int id) {
		Conseiller conseiller=getConseillerById(id);
		getSession().delete(conseiller);
		
	}

}
