package jardin.Flore;

import java.util.HashMap;

public interface IRacePure {
	public default void seReproduire(HashMap<String, Integer> panier, String nom) {
		panier.put(nom, panier.get(nom) + 3);
	}
}
