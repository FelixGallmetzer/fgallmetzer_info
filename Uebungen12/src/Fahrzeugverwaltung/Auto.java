package Fahrzeugverwaltung;
public class Auto extends Fahrzeug
{
	protected int ps = 0;

	public Auto(int geschwindigkeit, int ps) {
		super();
		setGeschwindigkeit(geschwindigkeit);
		setPs(ps);
	}

	public Auto() {
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
	
	public void setGeschwindigkeit(double geschwindigkeit) {
			this.geschwindigkeit = (int) geschwindigkeit;
		}

	public String toString() {
		String ret = "G: " + super.getGeschwindigkeit() + "K: " + super.getGeschwindigkeit() + "P: " + ps;
		return ret;
	}
}