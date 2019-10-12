package jardin.Flore;

import java.util.HashMap;

public interface IRacePure {
	public default void seReproduire(HashMap<String, Integer> panier) {
		panier.put(Vegetal.nom, panier.get(Vegetal.nom) + 3);
	}
}