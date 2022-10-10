package net.gobbz.fahrzeuge;

public class Lastwagen extends Auto {
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	int ladeflaeche;
	
	public Lastwagen(int geschwindigkeit, int ps, int Ladeflaeche) {
		super(geschwindigkeit, ps);
		this.setPs(ps); //Da setPs hier ueberschrieben wurde.
		this.setLadeflaeche(Ladeflaeche);
	}
	
	public Lastwagen(int geschwindigkeit, int kilometerstand, int ps, int ladeflaeche) {
		super(geschwindigkeit, ps, kilometerstand);
		this.setPs(ps); //Da setPs hier ueberschrieben wurde.
		this.setLadeflaeche(ladeflaeche);
	}

	/**
	 * @return the ladeflaeche
	 */
	public int getLadeflaeche() {
		return ladeflaeche;
	}

	/**
	 * @param ladeflaeche 
	 */
	public void setLadeflaeche(int ladeflaeche) {
		if (ladeflaeche > 0)
			this.ladeflaeche = ladeflaeche;
		else
			this.ladeflaeche = 1;
	}
	
	public void setPs(int ps) {
		if (ps >= 150) 
			this.ps = ps;
		else 
			this.setPs(150);
	}
	
	/**
	 * Gibt einen String in der folgenden Form zurueck:
	 * "Fahrzeug:\tG: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", P: " + this.ps + ", L: " + this.ladeflaeche
	 */
	public String toString() {
		return "Lastwagen G: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", P: " + this.ps + ", L: " + this.ladeflaeche; 
	}
}
