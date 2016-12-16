package org.iae.annecy.st1.etape1.model.client;

public class Client {
	private String nom;
	private String prenom;
	private String numeroClient;
	private Repertoire RepertoireClient;
	

	public Repertoire getRepertoireClient() {
		return RepertoireClient;
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
	
}
