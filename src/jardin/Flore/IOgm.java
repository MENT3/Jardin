package jardin.Flore;

import java.util.AbstractMap.SimpleEntry;

public interface IOgm {
	public default SimpleEntry<Integer, Integer> seDupliquer(int largeur, int longueur) {
		int x = (int) (Math.random() * (largeur - 1));
		int y = (int) (Math.random() * (longueur - 1));

		return new SimpleEntry<>(x, y);
	}
}
