package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;

public class CatalogueController {
	Catalogue cat;
	
	
	public CatalogueController(Catalogue c1) {
		// TODO Auto-generated constructor stub
		this.cat = c1;
	}


	public String  get(){
		return cat.afficherCatalogue();
	}

}
