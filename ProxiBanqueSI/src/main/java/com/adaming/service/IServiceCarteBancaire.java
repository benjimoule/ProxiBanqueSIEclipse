package com.adaming.service;

import java.util.List;

import com.adaming.entities.CarteBancaire;

public interface IServiceCarteBancaire {

	public List<CarteBancaire> getAllCarteBancaires();
	public CarteBancaire getCarteBancaireById(int id);
	public void addCarteBancaire(CarteBancaire cb);
	public void updateCarteBancaire(CarteBancaire cb);
	public void deleteCarteBancaire(int id);
}
