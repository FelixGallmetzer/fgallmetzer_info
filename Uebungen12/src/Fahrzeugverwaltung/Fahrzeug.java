package Fahrzeugverwaltung;
public class Fahrzeug
{
	protected int geschwindigkeit = 0;
	protected int kilometerstand = 0;

	public Fahrzeug(int geschwindigkeit) {
		this.setGeschwindigkeit(geschwindigkeit);
	}

	public Fahrzeug() {
	}
	
	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0)
			this.geschwindigkeit = geschwindigkeit;
		else
			this.geschwindigkeit = 0;
	}

	public int getGeschwindigkeit() {
		return this.geschwindigkeit;
	}

	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}

	public int getKilometerstand() {
		return kilometerstand;
	}
	
	public String toString() {
		String ret = "G: " + geschwindigkeit + "K: " + kilometerstand;
		
		return ret;
	}
}
