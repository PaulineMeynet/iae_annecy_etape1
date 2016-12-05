package org.iae.annecy.st1.etape1.model.produit;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalogue {
	private Produit produit;
	private ArrayList<Produit> produits = new ArrayList();
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public ArrayList<Produit> getProduits() {
		return produits;
	}
	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	public void ajouterProduit(Produit p){
		this.getProduits().add(p);
	}
	public void afficherCatalogue(){
		int i = 0;
		for(Produit Nproduit: this.getProduits()){
			System.out.println("-Numero du Produit :"+ i +" Produit de référence : " + Nproduit.getReference() + ". C'est un : " + 
		Nproduit.getDescription() + ". Son prix est de " + Nproduit.getPrix() + "€.");
			i++;
			}
	}
	public void produitChoisi(int choixProduit) {
		System.out.println("- Produit selectionné : "+ choixProduit +". Produit de référence : " + this.getProduits().get(choixProduit).getReference() + ". C'est un : " + 
				this.getProduits().get(choixProduit).getDescription() + ". Son prix est de " + this.getProduits().get(choixProduit).getPrix() + "€.");
	}
	public void attributchoisi(int choixProduit, int choixAttribut) {
		Scanner sc = new Scanner(System.in);
		
		switch(choixAttribut){
		
		/*case 1 :
			System.out.println("Entrez la nouvelle référence : ");
			int ref = sc.nextInt();
			this.getProduits().get(choixProduit).setReference(ref);
			break;*/
		
		case 2 : 
			System.out.println("Entrez la nouvelle description : ");
			String desc = sc.nextLine();
			this.getProduits().get(choixProduit).setDescription(desc);
			break;
		
		case 3 : 
			System.out.println("Entrez le nouveau prix : ");
			String prx = sc.nextLine();
			this.getProduits().get(choixProduit).setPrix(Double.parseDouble(prx));
			break;
		
		default :
			System.out.println("Le numéro entré n'est pas attribué");
			break;
		}
		
	}
}

