package net.gobbz.geometrischefiguren;

import java.awt.Graphics;

public class Ellipse extends Rechteck{
	
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	/**
	 * Custom-Konstruktor
	 * @param x-Koordinate
	 * @param y-Koordinate
	 * @param breite
	 * @param hoehe
	 */
	public Ellipse(int x, int y, int breite, int hoehe) {
		super(x, y, breite, hoehe);
	}
	
	public void paint(Graphics g) {
		g.setColor(this.farbe);
		if(gefuellt)
			g.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		else
			g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}
}
