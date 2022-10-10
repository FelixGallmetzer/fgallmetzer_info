package net.gobbz.geometrischefiguren;

public class Kreis extends Ellipse{
//Programm von Raphael, da ich meines nicht mehr gefunden habe
	/**
	 * Custom-Konstruktor
	 * @param x-Koordinate
	 * @param y-Koordinate
	 * @param breite
	 * @param hoehe
	 */
	public Kreis(int x, int y, int durchmesser) {
		super(x, y, durchmesser, durchmesser);
	}
}
