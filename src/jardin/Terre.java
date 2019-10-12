package jardin;

public class Terre {
	public static void main(String[] args) {
		Jardin jardin = new Jardin(5,5);
		
		jardin.ajouterPanier("Carotte", 10);
		jardin.ajouterPanier("Tomate", 8);
		jardin.ajouterPanier("Betterave", 2);
		jardin.ajouterPanier("Ail", 5);
		jardin.selectionMenu();
		System.out.println(jardin.toString());
	}
}

