package jardin;
import jardin.Flore.*;

public class Emplacement {

	private Vegetal vegetal;
	
	public Emplacement(Vegetal vegetal) {
		this.vegetal = vegetal;
	}

	@Override
	public String toString() {
		return vegetal.toString();
	}
	
	public Vegetal getVegetal() {
		return vegetal;
	}

	public void setVegetal(Vegetal vegetal) {
		this.vegetal = vegetal;
	}
	
}

