package net.gobbz.geometrischefiguren;

import java.awt.*;

//Programm von Raphael, da ich meines nicht mehr gefunden habe
/**
 * Klasse (welche von Punkt erbt), kann ein Rechteck auf einem JPanel zeichnen.
 * Es kann Farbe, Position, breite und hoehe definiert werden.
 * @author EndroidMc
 */
public class Rechteck extends Punkt {
	boolean gefuellt = false;
	
	/**
	 * Custom-Konstruktor
	 * @param x-Koordinate
	 * @param y-Koordinate
	 * @param breite
	 * @param hoehe
	 */
	public Rechteck(int x, int y, int breite, int hoehe) {
		setBounds(x, y, breite, hoehe);
	}

	public void paint(Graphics g) {
		g.setColor(this.farbe);
		if(gefuellt)
			g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		else
			g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}

	/**
	 * @return ob Objekt gefuellt ist
	 */
	public boolean isGefuellt() {
		return gefuellt;
	}

	/**
	 * @param ob Objekt gefuellt ist
	 */
	public void setGefuellt(boolean gefuellt) {
		this.gefuellt = gefuellt;
	}
	
}
