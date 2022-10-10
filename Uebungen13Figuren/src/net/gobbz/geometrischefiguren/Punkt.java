package net.gobbz.geometrischefiguren;

import javax.swing.*; // JComponent
import java.awt.*; // Color, Graphic

//Programm von Raphael, da ich meines nicht mehr gefunden habe
/**
 * Klasse, welche einen Punkt auf einem JPanel zeichnen kann. 
 * Man kann Farbe und Position festlegen
 * @author Raphael Siller
 */
public class Punkt extends JComponent {
	private static final int PUNKT_GROESSE = 8;
	protected Color farbe = Color.BLACK;

	// Defaultkonstruktor
	public Punkt() {
	}

	/**
	 * Custom-Konstruktor mit Koordinatenangabe
	 * @param x-Koordinate
	 * @param y-Koordinate
	 */
	public Punkt(int x, int y) {
		setBounds(x, y, PUNKT_GROESSE, PUNKT_GROESSE);
	}

	/**
	 * Setzt die Farbe
	 * @param farbe, als Variable des Typ Color
	 */
	public void setFarbe(Color farbe) {
		this.farbe = farbe;
		repaint();
	}

	/**
	 * Setzt die Farbe
	 * @param farbe, als rgb-Wert
	 */
	public void setFarbe(int r, int g, int b) {
		this.farbe = new Color(r, g, b);
		repaint();
	}
	
	/**
	 * Gibt die Farbe zurueck
	 * @return farbe, als Variable des Typ Color
	 */
	public Color getFarbe() {
		return this.farbe;
	}

	public void paint(Graphics g) {
		g.setColor(this.farbe);
		g.fillOval(0, 0, PUNKT_GROESSE, PUNKT_GROESSE);
	}

}