package net.gobbz.fahrzeuge;

public class Fahrrad extends Fahrzeug {
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	boolean beleuchtung;
	
	public Fahrrad(int geschwindigkeit, boolean beleuchtung) {
		super(1);
		if(0 < geschwindigkeit && geschwindigkeit <= 60)
			this.setGeschwindigkeit(geschwindigkeit);
		this.setBeleuchtung(beleuchtung);
	}
	
	public Fahrrad(int geschwindigkeit) {
		super(1);
		if(0 < geschwindigkeit && geschwindigkeit <= 60)
			this.setGeschwindigkeit(geschwindigkeit);
	}
	
	public Fahrrad(int geschwindigkeit, int kilometerstand, boolean beleuchtung) {
		super(geschwindigkeit, kilometerstand);
		this.setGeschwindigkeit(geschwindigkeit); //Da setGeschwindigkeit ueberschrieben wurde;
		this.setBeleuchtung(beleuchtung);
	}
	
	
	public void setGeschwindigkeit(int geschwindigkeit) {
		if(0 < geschwindigkeit && geschwindigkeit <= 60)
			this.geschwindigkeit = geschwindigkeit;
		else
			this.geschwindigkeit = 1;
	}
	/**
	 * @return the beleuchtung
	 */
	public boolean isBeleuchtung() {
		return beleuchtung;
	}

	/**
	 * @param beleuchtung the beleuchtung to set
	 */
	public void setBeleuchtung(boolean beleuchtung) {
		this.beleuchtung = beleuchtung;
	}
	
	/**
	 * Gibt einen String in der folgenden Form zurueck:
	 * "Fahrzeug:\tG: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", B: " + this.beleuchtung
	 */
	public String toString() {
		return "Fahrrad:\tG: " + this.geschwindigkeit + ", K: " + this.kilometerstand + ", B: " + this.beleuchtung; 
	}
}
