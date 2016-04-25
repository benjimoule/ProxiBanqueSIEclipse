package com.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.CarteBancaire;

@Repository("DaoCarteBancaire")
@Transactional
public class DaoCarteBancaire implements IDaoCarteBancaire {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	
	public List<CarteBancaire> getAllCarteBancaires() {
		
		return getSession().createQuery("From CarteBancaire").list();
	}



	public CarteBancaire getCarteBancaireById(int id) {
		
		return (CarteBancaire) getSession().get(CarteBancaire.class, id);
	}



	public void addCarteBancaire(CarteBancaire cb) {
		getSession().save(cb);
		
	}



	public void updateCarteBancaire(CarteBancaire cb) {
		getSession().update(cb);
		
	}


	public void deleteCarteBancaire(int id) {
		getSession().delete(getCarteBancaireById(id));
		
	}

}
