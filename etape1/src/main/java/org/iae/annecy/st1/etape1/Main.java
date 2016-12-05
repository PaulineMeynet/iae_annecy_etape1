/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.tools.ConsoleHelper;

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
	 */
	public static void main(final String[] args) {
		initUserModel();

		final DataView userData = mainController.get("user:display");
		final StringView userView = new UserTextFrenchView();

		ConsoleHelper.display(userView.build(userData));
		
		Produit p1 = new Produit("Super Blue",111, "Stylo bleu","C'est un super stylo avec un confort incroyable ...", 2.83);
		Produit p2 = new Produit("Super Red", 222, "Stylo rouge","un confort incroyable, ce stylo en aluminum...", 1.45);
		
		Catalogue c1 = new Catalogue();
		c1.ajouterProduit(p1);
		c1.ajouterProduit(p2);
		c1.afficherCatalogue();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Modifier le produit \n2 - Afficher le catalogue");
		int i = sc.nextInt();
		String refProduit;
		CatalogueController catController = new CatalogueController(c1);
		int choixAttribut = 0;
		if (i == 2){
			//c1.afficherCatalogue();
			System.out.println(catController.get());
					}
		else{
			
			System.out.println("Quel produit voulez-vous modifier ?");
			//while(sc.hasNextLine()){
				refProduit = sc.nextLine();
				//if(!refProduit = null){
				//	break;
				//}
			//}
			Produit produitSelectionne = c1.retrouveProduit(refProduit);
			c1.produitChoisi(produitSelectionne);
			System.out.println("1 - Nom \n2 - Description \n3 - Description Longue \n4 Prix");
			choixAttribut = sc.nextInt();
			c1.attributchoisi(produitSelectionne,choixAttribut);
			System.out.println("Modification effectuée ! ");
			c1.produitChoisi(produitSelectionne);
			//c1.afficherCatalogue();
			System.out.println(catController.get());
		}
	}
	 

	private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}

}
