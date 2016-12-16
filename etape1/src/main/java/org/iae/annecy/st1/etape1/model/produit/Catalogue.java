package org.iae.annecy.st1.etape1.model.produit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Catalogue implements Serializable {
	public Produit produit;
	public ArrayList<Produit> produits = new ArrayList();
	
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

	public void produitChoisi(Produit produit) {
		System.out.println("Nom du produit : " + produit.getNom()+ "- Produit de référence : " + produit.getReference() +" - Description : " + produit .getDescription() + " - Description longue: " + produit.getDescriptionLongue()+ " - Prix :" + produit.getPrix() + "€.");
	}	

	public Produit retrouveProduit(String refProduit){ //Parcours chaque produit et si get ref == reference
		Iterator<Produit> it = this.getProduits().iterator();
		Produit p = new Produit();
		while (it.hasNext()){
			Produit current = it.next();
			if(refProduit.equals (current.getReference())){
				return current ;
			}
		}
		return null;
	}
	
	public void save(){
		try{
			FileOutputStream fos = new FileOutputStream("File");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
}

