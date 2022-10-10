package net.gobbz.geometrischefiguren;

//Programm von Raphael, da ich meines nicht mehr gefunden habe
/**
 * Klasse (welche von Rechteck erbt), kann ein Quadrat auf einem JPanel zeichnen.
 * Es kann Farbe, Position und breite definiert werden.
 * @author EndroidMc
 */
public class Quadrat extends Rechteck {
	public Quadrat(int x, int y, int breite) {
		super(x, y, breite, breite);
	}

	public void setBounds(int x, int y, int breite) {
		super.setBounds(x, y, breite, breite);
	}

	public void setBounds(int x, int y, int breite, int hoehe) {
		super.setBounds(x, y, breite, breite);
	}

}
