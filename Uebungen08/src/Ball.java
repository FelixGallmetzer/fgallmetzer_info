import java.awt.Color;

public class Ball
{
	private int radius = 0;
	private int xposition = 60;
	private int yposition = 80;
	private int xrichtung = 0;
	private int yrichtung = 0;
	private java.awt.Color farbe = java.awt.Color.BLACK;
	
	/*
	 * der Radius des Balles darf nicht negativ sein. Ist die Eingabe negativ so wird der radius auf 0 gesetzt
	 * @param der zu setzende Radius
	 */
	public void setRadius(int radius) {
		
		if (radius > 0) {
			this.radius = radius;
		} else {
			this.radius = 0;
		}
	}
	
	/*
	 * Gibt den Radius des Balles zurück
	 * @return Radius vom Ball
	 */
	public int getRadius() {
		int ret = radius;
		
		return ret;
	}
	
	/*
	 *Setzt die X Position des Balles, sie darf nicht negativ sein. Wird ein negativer Wert übergeben, so wird sie auf 0 gesetzt.
	 *@param Die X position
	 */
	public void setX(int xposition) {
		
		if (xposition > 0) {
			this.xposition = xposition;
		} else {
			this.xposition = 0;
		}
	}
	
	/*
	 * Gibt die Xposition vom Ball zurück
	 * @return xposition vom Ball
	 */
	public int getX() {
		int ret = xposition;
		
		return ret;
	}
	
	/*
	 * Setzt den Yposition wert vom Ball. Wenn die Eingabe negativ ist, so wird 0 gesetzt
	 * @param Die Y position
	 */
	public void setY(int yposition) {
		
		if (yposition > 0) {
			this.yposition = yposition;
		} else {
			this.yposition = 0;
		}
	}
	
	/*
	 * Gibt den wert von der Yposition vom Ball zurück
	 * @return Yposition vom Ball
	 */
	public int getY() {
		int ret = yposition;
		
		return ret;
	}
	
	/*
	 * Setzt die X Richtung in die sich der Ball bewegt. Werte dürfen auch negativ sein
	 * @param die zu setzende X Richtung
	 */
	public void setXrichtung(int xrichtung) {
		
		this.xrichtung = xrichtung;		
	}
	
	/*
	 *Gibt die X Richtung in die sich der Ball bewegt zurück.
	 *@return X Richtung in die sich der Ball bewegt 
	 */
	public int getXrichtung() {
		int ret = xrichtung;
		
		return ret;
	}
	
	/*
	 * Setzt die Y Richtung in die sich der Ball bewegt. Werte dürfen auch negativ sein
	 * @param die zu setzende Y Richtung
	 */
	public void setYrichtung(int yrichtung) {
		
		this.yrichtung = yrichtung;
	}
	
	/*
	 *Gibt die Y Richtung in die sich der Ball bewegt zurück.
	 *@return Y Richtung in die sich der Ball bewegt 
	 */
	public int getYrichtung() {
		int ret = yrichtung;
		
		return ret;
	}
	
	/*
	 * Setzt die Farbe vom Ball.
	 * @param Farbe vom Ball
	 */
	public void setFarbe (java.awt.Color farbe) {
		
		this.farbe = farbe;
	}
	
	/*
	 * Gibt die Farbe vom Ball zurück.
	 * @return Farbe vom Ball
	 */
	public java.awt.Color getFarbe () {
		java.awt.Color ret = farbe;
		
		return ret;
	}
	
	/*
	 * Ausgabe
	 * @return gibt die Ausgabe als String zurück
	 */
	public String toString() {
		
		String ret = ("r = " + radius + ", xposition = " + xposition + ", yposition = " + yposition + ", xrichtung = " + xrichtung + " yrichtung = " + yrichtung);
		return ret;		
	}
	
	/*
	 * setzt zufällige Werte für die Variablen
	 */
	public void setZufaellig() {
		
		double radrand = Math.random() * 39;
		
		double xrand = Math.random() * 21;
		double yrand= Math.random() * 21;
		double [] farbrand = new double[3];
		for (int i = 0; i < 2; i++) {
			farbrand [i] = Math.random() * 256;
		}
		
		radius = (int) radrand + 2;
		
		if (xrand != 0) {
			xrichtung = (int) xrand - 10;
		} else {
			xrand = Math.random() * 21;
			xrichtung = (int) xrand - 10;
		}
		
		if (yrand != 0) {
			yrichtung = (int) yrand - 10;
		} else {
			yrand = Math.random() * 21;
			yrichtung = (int) yrand - 10;
		}
		
		farbe = new Color ((int) farbrand[0], (int) farbrand[1], (int) farbrand[2]);
	}
	
	/*
	 * bewegt die einzelnen Bälle
	 * @param g - Zeichnungsbereich
	 * @param width - Breite des Zeichnungsbereichs
	 * @param height - Höhe des Zeichnunsbereichs
	 */
	public void bewege(java.awt.Graphics g, int width, int height) {
		
		xposition += xrichtung;
		yposition += yrichtung;
		
		if (xposition <= -1 || xposition + radius > width) {
			xrichtung *= -1;
		}
		if (yposition <= -1 || yposition + radius > height) {
			yrichtung *= -1;
		}
		
		g.setColor(farbe);
		g.fillOval(xposition, yposition, radius, radius);
	}
}
