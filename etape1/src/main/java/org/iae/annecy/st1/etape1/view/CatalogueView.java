package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class CatalogueView {
	public String afficherCatalogue(Catalogue catalogue){
		String text = " ";
		for(Produit Nproduit: catalogue.getProduits()){
			text += (" Référence du produit : " + Nproduit.getReference() + ". Nom du produit : " + 
		Nproduit.getNom() + ". Description courte : "+ Nproduit.getDescription()+". Description Longue : "+ Nproduit.getDescriptionLongue()+ ". Prix = " + Nproduit.getPrix() + "€.\n");
			}
		
		return text;
	}

}
