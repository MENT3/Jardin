package jardin.Flore;

public class Vegetal {
	
	protected static String nom;

	protected String dessin[] = new String[6];

	protected Etat etat;
	
	public Vegetal() {
		this.dessin[0] = "_";
		this.dessin[1] = ".";
		this.dessin[2] = "|";
		this.dessin[5] = "#";
		
		this.etat = Etat.GRAINE;
	}
	
	@Override
	public String toString() {
		return this.dessin[this.etat.ordinal()];
	}
	
	public void grandir() {
		this.etat = Etat.values()[this.etat.ordinal()+1];
	}
	
	public int etatPlante() {
		return this.etat.ordinal();
	}

}
