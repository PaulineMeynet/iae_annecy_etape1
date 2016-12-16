package org.iae.annecy.st1.etape1.model.produit;

import java.io.Serializable;

public class Produit implements Serializable{
	private String reference ;
	private String description ;
	private double prix ;
	private String nom;
	private String descriptionLongue; 
	private Catalogue catalogue;
	private int quantite=0;
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getReference() {
		return reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescriptionLongue() {
		return descriptionLongue;
	}
	public void setDescriptionLongue(String descriptionLongue) {
		this.descriptionLongue = descriptionLongue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(){
		
	}
	public Produit(String nom, String reference, String description,String descriptionLongue, double prix){
		this.nom = nom;
		this.reference = reference;
		this.description = description;
		this.descriptionLongue = descriptionLongue;
		this.prix = prix ;
	}
	public void afficherInfos(){
		System.out.println("Nom du produit" + this.getNom()+ "référence : " + this.getReference() +
				".  Description courte : " + this.getDescription() + ". Description longue : " + this.getDescriptionLongue()+ ". Prix : "
				+ this.getPrix() + "euros.");
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

}
