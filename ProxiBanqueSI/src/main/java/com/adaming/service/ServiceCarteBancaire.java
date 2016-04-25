package com.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.IDaoCarteBancaire;
import com.adaming.entities.CarteBancaire;

@Service(value = "ServiceCarteBancaire")
public class ServiceCarteBancaire implements IServiceCarteBancaire {

	@Autowired
	private IDaoCarteBancaire daoCarteBancaire;
	
	
	public List<CarteBancaire> getAllCarteBancaires() {
		
		return daoCarteBancaire.getAllCarteBancaires();
	}


	@Override
	public CarteBancaire getCarteBancaireById(int id) {
		return daoCarteBancaire.getCarteBancaireById(id);
	}


	@Override
	public void addCarteBancaire(CarteBancaire cb) {
		daoCarteBancaire.addCarteBancaire(cb);
		
	}


	@Override
	public void updateCarteBancaire(CarteBancaire cb) {
		daoCarteBancaire.updateCarteBancaire(cb);
		
	}


	@Override
	public void deleteCarteBancaire(int id) {
		daoCarteBancaire.deleteCarteBancaire(id);
		
	}

}
