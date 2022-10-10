package Fahrzeugverwaltung;
public class Lastwagen extends Auto
{
	protected int ladeflaeche = 0;

	public void setLadeflaeche(int ladeflaeche) {
		if (ladeflaeche > 0) {
			this.ladeflaeche = ladeflaeche;
		} else {
			this.ladeflaeche = 0;
		}
	}

	public int getLadeflaeche() {
		return ladeflaeche;
	}

	public void setPS(int ps) {
		if (ps > 150) {
			this.ps = ps;
		} else {
			this.ps = 150;
		}
	}

	public Lastwagen(int ladeflaeche, int geschwindigkeit, int ps) {
		super();
		setLadeflaeche(ladeflaeche);
		setGeschwindigkeit(geschwindigkeit);
		setPs(ps);
	}
	
	public String toString() {
		String ret = "G: " + super.getGeschwindigkeit() + "K: " + super.getKilometerstand() + "P: " + super.getPs() + "L: " + ladeflaeche;
		return ret;
	}
}
