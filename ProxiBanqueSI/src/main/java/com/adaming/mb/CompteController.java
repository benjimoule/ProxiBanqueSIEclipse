package com.adaming.mb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.entities.CompteCourant;
import com.adaming.entities.CompteEpargne;
import com.adaming.service.IServiceCompteCourant;
import com.adaming.service.IServiceCompteEpargne;

public class CompteController {

	@Autowired
	private IServiceCompteCourant serviceCompteCourant;
	
	@Autowired
	private IServiceCompteEpargne serviceCompteEpargne;
	
	private List<CompteCourant> listCC;
	private List<CompteEpargne> listCE;
}
