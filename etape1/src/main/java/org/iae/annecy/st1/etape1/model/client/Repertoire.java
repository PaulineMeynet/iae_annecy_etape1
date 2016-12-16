package org.iae.annecy.st1.etape1.model.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class Repertoire {
	public ArrayList<Client> clients = new ArrayList();

	
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public void ajouterClient(Client c){
		this.getClients().add(c);
	}

	public String afficherRepertoire(){
		String text = " ";
		for(Client Nclient: this.getClients()){
			text += ("Numéro du client : " + Nclient.getNumeroClient() + "- Nom du client : " + 
					Nclient.getNom() + "- Prénom du client : "+ Nclient.getPrenom()+".\n");
		}

		return text;
	}

	public void clientChoisi(Client client) {
		System.out.println("Numéro du client :" + client.getNumeroClient() + "Nom du client : " + client.getNom()+ "- Prénom du client :"+ client.getPrenom() +".");
	}
	public void attributchoisiClient(Client client, int choixAttributClient) {
		Scanner sc = new Scanner(System.in);

		switch(choixAttributClient){
		case 1: 
			ConsoleHelper.display("Entrez le nouveau nom du client : ");
			String nom = sc.nextLine();
			client.setNom(nom);
			break;

		case 2: 
			ConsoleHelper.display("Entrez le nouveau prénom du client : ");
			String prenom = sc.nextLine();
			client.setPrenom(prenom);
			break;

		default :
			ConsoleHelper.display("Le numéro entré n'est pas attribué");
			break;
		}
	}

	public Client retrouveClient(String numClient){ 
		Iterator<Client> it = this.getClients().iterator();
		Client c = new Client();
		while (it.hasNext()){
			Client current = it.next();
			if(numClient.equals (current.getNumeroClient())){
				return current ;
			}
		}
		return null;
	}
	
	public int retrouveClientnumero(String numClient){ 
		Iterator<Client> it = this.getClients().iterator();
		Client c = new Client();
		int i=0;
		while (it.hasNext()){
			Client current = it.next();
			if(numClient.equals (current.getNumeroClient())){
				return i ;
			}
			i++;
		}
		return -1;
	}
}
