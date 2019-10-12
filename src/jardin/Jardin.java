package jardin;

import java.util.HashMap;
import java.util.Scanner;

import jardin.Flore.*;

public class Jardin {
	private int longueur;
	private int largeur;
	private Emplacement[][] emplacement;
	private HashMap<String, Integer> panier;
	
	Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		this.emplacement = new Emplacement[longueur][largeur];
	}
	
	public void ajouterPanier(String nomVegetal, int quantite) {
		this.panier.put(nomVegetal, quantite);
	}
	
	public String toString() {
		
		String result = "";
		String jardin = "";
		String panier = "";
		
		jardin = jardin.concat("Voici votre Jardin : \n");
		for(int i = 0; (i < this.largeur); i++) {
			for(int j = 0; (j < this.longueur); j++) {
				if(emplacement[i][j] == null) {
					jardin = jardin.concat("o");
				} else {
					jardin = jardin.concat(emplacement[i][j].toString());
				}
			}
			jardin = jardin.concat("\n");
		}
		
		result = result.concat(jardin);
		
		panier = panier.concat("\nEt notre panier contient : \n\n");
		
		panier = panier.concat("Tomate : " + ((this.panier.get("Tomate") == null ) ? "0" : this.panier.get("Tomate")) + " graine(s)\n");
		panier = panier.concat("Carotte : " + ((this.panier.get("Carotte") == null ) ? "0" : this.panier.get("Carotte")) + " graine(s)\n");
		panier = panier.concat("Ail : " + ((this.panier.get("Ail") == null ) ? "0" : this.panier.get("Ail")) + " graine(s)\n");
		panier = panier.concat("Betterave : " + ((this.panier.get("Betterave") == null ) ? "0" : this.panier.get("Betterave")) + " graine(s)\n");
			
		result = result.concat(panier);
		
		return result;
	}
	
	public int scanner() {
		System.out.print(">> ");
		
		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextInt();
			
		} catch(Exception e) {
			System.out.println("Une erreur c'est produite : \n"
					+ e.toString()
					+ "\n");
			this.selectionMenu();
			return 0;
		}
	}
	
	public void afficherMenu() {
		System.out.println(this.toString());;
		System.out.println("1. Semer une graine\n"
				+ "2. Récolter toutes les plantes qui sont matures\n"
				+ "3. Passer à la saison suivante (toutes les plantes grandissent)\n"
				+ "4. Quitter l'application\n");
	}
		
	public void selectionMenu() {
		afficherMenu();
		int res = this.scanner();
		
		switch(res) {
		case 1:
			this.semer();
			break;
			
		case 2:
			this.recolter();
			break;
			
		case 3:
			this.saisonSuivante();
			break;
			
		case 4:
			System.exit(-1);
			break;
		default:
			System.out.println("\n- Aucun numéro ne correspond à ce que vous avez selectionné - \n");
			this.selectionMenu();
			break;
		}
	}
	
	public void semer() {
		System.out.println("Où souhaitez vous plantez votre graine ?\n"
				+ "X : ");
		
		int x = this.scanner();
		
		System.out.println("Y : ");
		
		int y = this.scanner();
		
		if((x > this.largeur - 1) || (y > this.longueur - 1)) {
			System.out.println("\n- Les coordonnées entrées ne correspondes pas -\n");
			this.semer();
		}
		
		System.out.println("Que souhaitez vous plantez : \n\n"
				+ "1. Tomate \n"
				+ "2. Carotte \n"
				+ "3. Ail \n"
				+ "4. Betterave \n");
		
		int res = this.scanner();
		
		switch(res) {
		case 1:
			this.emplacement[x][y] = new Emplacement(new Tomate());
			if(this.panier.get("Tomate") <= 0) {
				System.out.println("Impossible de planter ce végétal, vous n'avez plus de graine(s)");
				this.selectionMenu();
				break;
			} else {
				this.ajouterPanier("Tomate", (this.panier.get("Tomate") - 1));
				break;
			}
			
		case 2:
			this.emplacement[x][y] = new Emplacement(new Carotte());
			if(this.panier.get("Carotte") <= 0) {
				System.out.println("Impossible de planter ce végétal, vous n'avez plus de graine(s)");
				this.selectionMenu();
				break;
			} else {
				this.ajouterPanier("Carotte", (this.panier.get("Carotte") - 1));
				break;
			}
			
		case 3:
			this.emplacement[x][y] = new Emplacement(new Ail());
			if(this.panier.get("Ail") <= 0) {
				System.out.println("Impossible de planter ce végétal, vous n'avez plus de graine(s)");
				this.selectionMenu();
				break;
			} else {
				this.ajouterPanier("Ail", (this.panier.get("Ail") - 1));
				break;
			}
			
		case 4:
			this.emplacement[x][y] = new Emplacement(new Betterave());
			if(this.panier.get("Betterave") <= 0) {
				System.out.println("Impossible de planter ce végétal, vous n'avez plus de graine(s)");
				this.selectionMenu();
				break;
			} else {
				this.ajouterPanier("Betterave", (this.panier.get("Betterave") - 1));
				break;
			}
		default:
			System.out.println("\n- Aucun numéro ne correspond à ce que vous avez selectionné - \n");
			this.semer();
			break;
		}
		this.selectionMenu();
	}
	
	public void recolter() {		
		for(int i = 0; i < this.largeur; i++) {
			for(int j = 0; j < this.longueur; j++) {
				if((emplacement[i][j] != null) && (emplacement[i][j].getVegetal().etatPlante() == 4)) {
					if(this.emplacement[i][j].getVegetal() instanceof IRacePure) {
						IRacePure v = (IRacePure) this.emplacement[i][j].getVegetal();
						v.seReproduire(this.panier);
					} else if(this.emplacement[i][j].getVegetal() instanceof IOgm) {
						IOgm v = (IOgm) this.emplacement[i][j].getVegetal();
						if(this.emplacement[ v.seDupliquer(this.largeur, this.longueur).getKey() ][ v.seDupliquer(this.largeur, this.longueur).getValue() ] == null ) {
							System.out.println("Key : " + v.seDupliquer(this.largeur, this.longueur).getKey());
							System.out.println("Value : " + v.seDupliquer(this.largeur, this.longueur).getValue());
							this.emplacement[v.seDupliquer(this.largeur, this.longueur).getKey()][v.seDupliquer(this.largeur, this.longueur).getValue()] = new Emplacement(new Betterave());
						}
					}
					this.emplacement[i][j] = null;
				}
			}
		}
		this.selectionMenu();
	}
	
	public void saisonSuivante() {
		for(int i = 0; i < this.largeur; i++) {
			for(int j = 0; j < this.longueur; j++) {
				if(emplacement[i][j] != null && (this.emplacement[i][j].getVegetal().etatPlante() < 5)) {
					this.emplacement[i][j].getVegetal().grandir();
				}
			}
		}
		this.selectionMenu();
	}
	
	
}


