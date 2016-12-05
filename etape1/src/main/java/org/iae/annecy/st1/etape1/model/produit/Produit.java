package org.iae.annecy.st1.etape1.model.produit;

public class Produit {
	private int reference ;
	private String description ;
	private double prix ;
	private String nom;
	private String descriptionLongue; 
	private Catalogue catalogue;
	
	public int getReference() {
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(String nom, int reference, String description,String descriptionLongue, double prix){
		this.nom = nom;
		this.reference = reference;
		this.description = description;
		this.descriptionLongue = descriptionLongue;
		this.prix = prix ;
	}
	public void afficherInfos(){
		System.out.println("Le produit" + this.getNom()+ "qui a pour référence" + this.getReference() +
				".  Sa description courte : " + this.getDescription() + ". Sa description longue : " + this.getDescriptionLongue()+ " et son prix est de "
				+ this.getPrix() + "euros.");
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

}
