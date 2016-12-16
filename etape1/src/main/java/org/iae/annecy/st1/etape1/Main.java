/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;


import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.BasicDataParam;
import org.iae.annecy.st1.common.mvc.ConsoleInputView;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.model.person.PersonAddModel;
import org.iae.annecy.st1.etape1.model.person.PersonGetModel;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonAddFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonCreateFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonGetFrenchView;
import org.iae.annecy.st1.tools.ConsoleHelper;
import org.iae.annecy.st1.etape1.model.client.*;
import org.iae.annecy.st1.etape1.controller.RepertoireController;
/**
 * Classe permettant de tester le MVC.
 * 
 * @author Djer1013
 */
public class Main {

	/**
	 * Controller pemettant le traitement des actions d'exemple.
	 */
	private static MainController mainController;

	static {
		Main.mainController = new MainController();
	}

	/**
	 * Lance l'application.
	 * 
	 * @param args
	 *            command line parameters
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(final String[] args) throws IOException, ClassNotFoundException {
		// partie du prof
		initUserModel();
		initCustomerModel();
		
		final Scanner scan = new Scanner(System.in, "UTF-8");

		final DataView userData = mainController.get("user:display");
		final StringView userView = new UserTextFrenchView();

		// affichage nom
		ConsoleHelper.display(userView.build(userData));
		
		// gestion produit, client, catalogue et repertoire
		Produit p1 = new Produit("Super Blue","111", "Stylo bleu","C'est un super stylo avec un confort incroyable ...", 2.83);
		Produit p2 = new Produit("Super Red", "222", "Stylo rouge","un confort incroyable, ce stylo en aluminum...", 1.45);
		Catalogue c1 = null;
		
		try{
			FileInputStream fichier = new FileInputStream("File");
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream("File"));
			c1 =(Catalogue) ois.readObject();
		}catch(FileNotFoundException e){
			c1 = new Catalogue();
			c1.ajouterProduit(p1);
			c1.ajouterProduit(p2);
		}
		
		CatalogueController cat = new CatalogueController();
		cat.set(c1);
		Client cl1 = new Client ("Dupond", "Alexis", "A1001");
		Client cl2 = new Client ("Dupont", "Léon", "A1002");
		

		//ConsoleHelper.display(c1.afficherCatalogue()); // équivalent de SOP
		Repertoire r1 = new Repertoire();
		r1.ajouterClient(cl1);
		r1.ajouterClient(cl2);
		//ConsoleHelper.display(r1.afficherRepertoire());
		
		menuDepart(c1, r1);
		
	}
	
	private static void menuDepart(Catalogue c1, Repertoire r1){
		CatalogueController cat = new CatalogueController();
		cat.set(c1);
		RepertoireController rep = new RepertoireController(r1);
		// première saisie utilisateur pour le premier menu
		Scanner sc = new Scanner(System.in);
		Integer choixMenu = menuGeneral(sc);
		
		switch (choixMenu){
			case 0:
				ConsoleHelper.display("Sortie ! Merci et à bientôt :)");
				System.exit(0);
				break;
			case 1:
				//afficherCatalogue(cat);
				ConsoleHelper.display(cat.get());
				break;
			case 2:
				modifierProduit(c1);
				break;
			case 3:
				ajouterProduit(c1);
				break;
			case 4: 
				afficherRepertoire(rep);
				break;
			//case 5:
				//modiferClient(rep);
				//break;
			default:
				ConsoleHelper.display("Erreur de saisie, veuillez ré-essayer, Merci !!");
				break;
		}
		menuDepart(c1, r1);
	}
	
	private static void afficherCatalogue(CatalogueController cat){
		ConsoleHelper.display(cat.get());
	}
	
	private static void afficherRepertoire(RepertoireController rep){
		ConsoleHelper.display(rep.get());
	}
	private static void modifierProduit(Catalogue c1){
		// attributs
		CatalogueController cat = new CatalogueController();
		cat.set(c1);
		String refProduit = null;
		int choixAttribut = 0;
		
		// choix produit
		ConsoleHelper.display("Entrez la référence du produit que vous voulez modifier ?");
		ConsoleHelper.display(cat.get());
		Scanner scanner = new Scanner(System.in);
		refProduit = scanner.nextLine();
		Produit produitSelectionne = c1.retrouveProduit(refProduit);
		c1.produitChoisi(produitSelectionne);
		
		// choix modif
		ConsoleHelper.display("1 - Nom \n2 - Description \n3 - Description Longue \n4 - Prix");
		Scanner scanner2 = new Scanner(System.in);
		choixAttribut = scanner2.nextInt();
		cat.attributchoisi(produitSelectionne,choixAttribut);
		ConsoleHelper.display("Modification effectuée ! ");
		c1.produitChoisi(produitSelectionne);
		//c1.afficherCatalogue();
		ConsoleHelper.display(cat.get());
	}
	
	private static void ajouterProduit(Catalogue c1){
	// Attributs
		CatalogueController cat = new CatalogueController();
		cat.set(c1);
		int choixConfirmation = 0;
		Produit nouveauProduit= new Produit();
		
	//Définir la référence du nouveau produit
		ConsoleHelper.display("Veuillez entrer la référence du nouveau produit : ");
		Scanner scannerre = new Scanner(System.in);
		String ref = scannerre.nextLine();
		Produit monProduit = c1.retrouveProduit(ref);
		//if(monProduit.retrouveProduit(ref))
		nouveauProduit.setReference(ref);
		
	//Définir le nom du nouveau produit
		ConsoleHelper.display("Veuillez entrer le nom du nouveau produit : ");
		Scanner scannern = new Scanner(System.in);
		String nom = scannern.nextLine();
		nouveauProduit.setNom(nom);
		
	//Définir la description du nouveau produit
		System.out.println("Veuillez entrer la description du nouveau produit : ");
		Scanner scannerdesc = new Scanner(System.in);
		String desc = scannerdesc.nextLine();
		nouveauProduit.setDescription(desc);
	
	//Définir la description longue du nouveau produit
		System.out.println("Entrez la description longue du nouveau produit : ");
		Scanner scannerdescl = new Scanner(System.in);
		String descl = scannerdescl.nextLine();
		nouveauProduit.setDescriptionLongue(descl);
		
	//Définir le prix du nouveau produit
		do{
		System.out.println("Entrez le prix du nouveau produit : ");
		Scanner scannerp = new Scanner(System.in);
		double prx = scannerp.nextDouble();
		nouveauProduit.setPrix(prx);
		
		if (nouveauProduit.getPrix() <= 0){
			ConsoleHelper.display("Prix négatif. Recommencez :");
			}
		}while(nouveauProduit.getPrix()<= 0);
		
		
	// Demande de confirmation d'ajout au catalogue
		c1.produitChoisi(nouveauProduit);
		ConsoleHelper.display("Voulez-vous ajouter ce produit au catalogue ? \n1 - Oui \n2 - Non");
		Scanner scanner3 = new Scanner(System.in);
		choixConfirmation = scanner3.nextInt();
		cat.confirmationProduitAjout(choixConfirmation);
		c1.ajouterProduit(nouveauProduit);
		ConsoleHelper.display("Procédure terminée ! ");
		ConsoleHelper.display(cat.get());
	}
	 
	/*private static void modifierClient(Repertoire r1){
		// attributs
		RepertoireController rep = new RepertoireController(r1);
		String refClient = null;
		int choixAttributClient = 0;
		
		// choix client
		ConsoleHelper.display("Entrez le numéro de client que vous voulez modifier ?");
		ConsoleHelper.display(rep.get());
		Scanner scannercli1 = new Scanner(System.in);
		refClient = scannercli1.nextLine();
		Client clientSelectionne = r1.retrouveClient(refClient);
		//r1.clientChoisi(clientSelectionne);
		
		// choix modif
		ConsoleHelper.display("1 - Nom \n2 - Prénom \n");
		Scanner scannercli2 = new Scanner(System.in);
		choixAttributClient = scannercli2.nextInt();
		r1.attributchoisiClient(clientSelectionne,choixAttributClient);
		ConsoleHelper.display("Modification effectuée ! ");
		r1.clientChoisi(clientSelectionne);
		//r1.afficherRepertoire();
		ConsoleHelper.display(r1.get());
	}*/
	
	private static Integer menuGeneral(Scanner sc){
		ConsoleHelper.display("0 - Quitter le système \n1 - Afficher le catalogue \n2 - Modifier un produit \n3 - Ajouter un produit \n4 - Afficher le repertoire de client \n5- Modifier un client");
		int i = sc.nextInt();
		return i;
	}	
	
	// partie du prof
	
		/*
		// get a Person
		DataParam searchPersonParam = new BasicDataParam();
		searchPersonParam.add("id", "10"); //0-5 inconu, 5-10 TEST, >10 DERUETTE
		final DataView customerData = mainController.get("person:get", searchPersonParam);
		final StringView customerGetView = new PersonGetFrenchView();
		
		ConsoleHelper.display(customerGetView.build(customerData));
		
		//demande l'ajout d'une personne attribut/attribut
		DataParam newCustomer = new BasicDataParam();
		String personId = ConsoleHelper.read(scan, "Quel est l'ID du client ?");
		newCustomer.add("id", personId); // <100 = OK, sinon KO
		String personNom = ConsoleHelper.read(scan, "Quel est le nom du client ?");
		newCustomer.add("nom", personNom);
		String personPrenom = ConsoleHelper.read(scan, "Quel est le prénom du client ?");
		newCustomer.add("prenom", personPrenom);
		
		final DataView customerAddData = mainController.get("person:add", newCustomer);
		final StringView customerAddView = new PersonAddFrenchView();
		
		ConsoleHelper.display(customerAddView.build(customerAddData));
		
		//Demande l'ajout d'une personne en une seul fois
		final ConsoleInputView customerCreateView = new PersonCreateFrenchView();
		customerCreateView.ask(scan);
		
		final DataView customerAddDataBulk = mainController.get("person:add", newCustomer);
		final StringView customerAddViewBulk = new PersonAddFrenchView();
		
		ConsoleHelper.display(customerAddViewBulk.build(customerAddDataBulk));
		
	}
*/
	private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}
	
	private static void initCustomerModel() {
		final PersonGetModel customerGetModel = new PersonGetModel();
		customerGetModel.register(mainController);
		
		final PersonAddModel customerAddModel = new PersonAddModel();
		customerAddModel.register(mainController);
	}

}
	