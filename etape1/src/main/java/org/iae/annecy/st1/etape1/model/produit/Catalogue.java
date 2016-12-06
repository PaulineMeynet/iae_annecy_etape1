package org.iae.annecy.st1.etape1.model.produit;

import java.util.ArrayList;
import java.util.Iterator;
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
	public String afficherCatalogue(){
		int i = 0;
		String text = " ";
		for(Produit Nproduit: this.getProduits()){
			text += ("-Numero du Produit :"+ i +" Référence du produit : " + Nproduit.getReference() + ". Nom du produit : " + 
		Nproduit.getNom() + ". Description courte : "+ Nproduit.getDescription()+". Description Longue : "+ Nproduit.getDescriptionLongue()+ ". Prix = " + Nproduit.getPrix() + "€.\n");
			i++;
			}
		
		return text;
	}
	public void produitChoisi(Produit produit) {
		System.out.println("Nom du produit : " + produit.getNom()+ "- Produit de référence : " + produit.getReference() +" - Description : " + produit .getDescription() + " - Description longue: " + produit.getDescriptionLongue()+ " - Prix :" + produit.getPrix() + "€.");
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
	public Produit retrouveProduit(String refProduit){ //Parcours chaque produit et si getref == reference
		Iterator<Produit> it=this.getProduits().iterator();
		Produit p = new Produit();
		while (it.hasNext()){
			Produit current = it.next();
			if(refProduit.equals (it.next().getReference())){
				return it.next() ;
			}
		}
		return p;
	}
}

