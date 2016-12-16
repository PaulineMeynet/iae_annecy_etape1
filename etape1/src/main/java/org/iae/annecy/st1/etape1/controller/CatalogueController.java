package org.iae.annecy.st1.etape1.controller;

import java.util.Scanner;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.CatalogueView;

public class CatalogueController {
	Catalogue cat;
	private CatalogueView catv = new CatalogueView();

	public void set(Catalogue c1){
		this.cat = c1;
	}
	
	public String get(){
		return catv.afficherCatalogue(cat);
	}
	
	public void save(){
		cat.save();
	}
	
	public void attributchoisi(Produit produit, int choixAttribut) {
		Scanner sc = new Scanner(System.in);
		
		switch(choixAttribut){
		
		/*case 1 :
			System.out.println("Entrez la nouvelle référence : ");
			int ref = sc.nextInt();
			this.getProduits().get(choixProduit).setReference(ref);
			break;*/
		case 1: 
			System.out.println("Entrez un nouveau nom : ");
			String nom = sc.nextLine();
			produit.setNom(nom);
			break;
		
		case 2 : 
			System.out.println("Entrez la nouvelle description : ");
			String desc = sc.nextLine();
			produit.setDescription(desc);
			break;
		
		case 3 : 
			System.out.println("Entrez la nouvelle description longue : ");
			String descl = sc.nextLine();
			produit.setDescriptionLongue(descl);
			break;
			
		case 4:
			System.out.println("Entrez le nouveau prix : ");
			String prx = sc.nextLine();
			produit.setPrix(Double.parseDouble(prx));
			break;
			
		default :
			System.out.println("Le numéro entré n'est pas attribué");
			break;
		}
	}
		
	public void confirmationProduitAjout(int choixConfirmation) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		switch (choixConfirmation){
		case 1: 
			System.out.println("Le produit a été ajouté au catalogue avec succès ");
			break;
		
		case 2 : 
			System.out.println("Le produit n'a pas été ajouté au catalogue");
			break;
			
		default :
			System.out.println("Le numéro entré n'est pas attribué. Veuillez saisir soit 1 pour oui soit 2 pour non.");
			break;
		}
		
	}

}
