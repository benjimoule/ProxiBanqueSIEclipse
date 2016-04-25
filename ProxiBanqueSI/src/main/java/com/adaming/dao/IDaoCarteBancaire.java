package com.adaming.dao;

import java.util.List;

import com.adaming.entities.CarteBancaire;

public interface IDaoCarteBancaire {
	List<CarteBancaire> getAllCarteBancaires();
	CarteBancaire getCarteBancaireById(int id);
	void addCarteBancaire(CarteBancaire cb);
	void updateCarteBancaire(CarteBancaire cb);
	void deleteCarteBancaire(int id);
}