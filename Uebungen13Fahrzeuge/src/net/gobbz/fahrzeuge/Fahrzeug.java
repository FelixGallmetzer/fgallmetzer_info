package net.gobbz.fahrzeuge;

public class Fahrzeug {
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	protected int geschwindigkeit = 0;
	protected int kilometerstand = 0;
	public Fahrzeug() {}
	
	public Fahrzeug(int geschwindigkeit) {
		this.setGeschwindigkeit(geschwindigkeit);
	}
	
	public Fahrzeug(int geschwindigkeit, int kilometerstand) {
		this.setGeschwindigkeit(geschwindigkeit);
		this.setKilometerstand(kilometerstand);
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

	/**
	 * @return the kilometerstand
	 */
	public int getKilometerstand() {
		return kilometerstand;
	}

	/**
	 * @param kilometerstand the kilometerstand to set
	 */
	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}
	
	/**
	 * Gibt einen String in der folgenden Form zurueck:
	 * "Fahrzeug:\tG: " + this.geschwindigkeit + ", K: " + this.kilometerstand
	 */
	public String toString() {
		return "Fahrzeug G: " + this.geschwindigkeit + ", K: " + this.kilometerstand; 
	}
}
