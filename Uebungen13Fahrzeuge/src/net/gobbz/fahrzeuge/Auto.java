package net.gobbz.fahrzeuge;

public class Auto extends Fahrzeug {
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	protected int ps = 0;
	public Auto() {}
	
	public Auto(int geschwindigkeit, int ps) {
		super(geschwindigkeit);
		this.setPs(ps);
	}
	
	public Auto(int geschwindigkeit, int kilometerstand, int ps) {
		super(geschwindigkeit, kilometerstand);
		this.setPs(ps);
	}
	
	public void setPs(int ps) {
		if (ps > 0)
			this.ps = ps;
		else
			this.ps = 0;
	}

	public int getPs() {
		return this.ps;
	}
	
	/**
	 * Gibt einen String in der folgenden Form zurueck:
	 * "Fahrzeug:\tG: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", P: " + this.ps
	 */
	public String toString() {
		return "Auto G: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", P: " + this.ps; 
	}
}
