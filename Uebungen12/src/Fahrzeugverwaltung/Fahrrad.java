package Fahrzeugverwaltung;
public class Fahrrad extends Fahrzeug
{
	protected boolean beleuchtung = true;

	public Fahrrad(int geschwindigkeit) {
		super();
		setGeschwindigkeit(geschwindigkeit);
	}

	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit > 0 && geschwindigkeit < 60) {
			this.geschwindigkeit = geschwindigkeit;
		}
	}

	public void setBeleuchtung(boolean beleuchtung) {
		this.beleuchtung = beleuchtung;
	}

	public boolean getBeleuchtung() {
		return beleuchtung;
	}
	
	public String toString() {
		String ret = "G: " + super.getGeschwindigkeit() + "K: " + super.getKilometerstand() + "B: " + beleuchtung;
		return ret;
	}
}
