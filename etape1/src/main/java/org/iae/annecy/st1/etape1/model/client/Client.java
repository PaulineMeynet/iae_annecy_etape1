package org.iae.annecy.st1.etape1.model.client;

import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class Client {
	private String nom;
	private String prenom;
	private String numeroClient;
	private Repertoire RepertoireClient;
	private ArrayList<Produit> produit= new  ArrayList<Produit>();
	

	public ArrayList<Produit> getProduit() {
		return produit;
	}
	public void setProduit(ArrayList<Produit> produit) {
		this.produit = produit;
	}
	public Repertoire getRepertoireClient() {
		return RepertoireClient;
	}
	
	public void ajouterproduit(Produit produit){
		this.getProduit().add(produit);
	}
	
	public void afficherproduit(){
		for(Produit produit : this.getProduit()){
			produit.afficherInfos();
		}
	}
	public void setRepertoireClient(Repertoire repertoireClient) {
		RepertoireClient = repertoireClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}

	public Client(){
		
	}
	
	public Client(String nom, String prenom, String numero){
		this.nom = nom;
		this.prenom = prenom;
		this.numeroClient = numero;
		
	}
	
	public void afficherClient(){
		System.out.println("Numero du client :" + this.getNumeroClient() + "Nom du client : " + this.getNom()+ " Prénom du client : " + this.getPrenom());
	}
	
	public void afficherprixproduit(){
		double totale =0;
		for(Produit produit : this.getProduit()){
			ConsoleHelper.display("Nom produit : "+produit.getNom());
			ConsoleHelper.display("prix unitaire : "+produit.getPrix());
			ConsoleHelper.display("quantite : "+produit.getQuantite());
			ConsoleHelper.display("prix * quantite : "+produit.getQuantite()*produit.getPrix());
			totale = produit.getQuantite()*produit.getPrix() +totale;
		}
		ConsoleHelper.display("prix totale du panier : "+totale);
	}
	
}
