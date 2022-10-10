public class Kreis
{
	private double radius = 0.0;
	
	/*
	* Setzt den Radius. Der Radius wird nur gesetzt, falls der übergebene Parameter radius größer oder gleich 0 ist,
	* ansonsten wird der Radius nicht gesetzt und der alte Wert des Radiuses beibehalten.
	* @param radius - der zu setzende Radius
	*/
	public void setRadius (double radius) {
		
		if (radius >= 0) {
			this.radius = radius;
		}
		else {
			System.out.println("Der Radius muss größer oder gleich 0 sein.");
		}
	}
	
	/*
	 * Liefert den Radius des Kreises zurück
	 * @return den Radius des Kreises
	 */
	public double getRadius () {
		
		return radius;
	}
	
	/*
	 * Setzt den Umfang des Kreises. Der übergebene Umfang darf nicht 0 sein.
	 * Die Methode errechnet sich aus dem Umfang den Radius und setzt diesen
	 * @param umfang - der zu setzende Umfang
	 */
	public void setUmfang (double umfang) {
		
		if (umfang > 0) {
			radius = umfang/(2 * Math.PI);
		}
		else {
			System.out.println("Der Umfang muss größer als 0 sein.");
		}
	}
	
	/*
	 * Liefert den Umfang des Kreises zurück. Dieser wird aus dem Radius berechnet
	 * @return den Umfang des Kreises
	 */
	public double getUmfang () {
		
		return (2 * Math.PI * radius);
	}
	
	/*
	 * Setzt die Fläche des Kreises. Die übergebene Fläche darf nicht 0 sein.
	 * Die Methode errechnet sich aus der Fläche den Radius und setzt diesen
	 * @param flaeche - die zu setzende Fläche
	 */
	public void setFlaeche (double flaeche) {
		
		if (flaeche > 0) {
			radius = Math.sqrt(flaeche/Math.PI);
		}
		else {
			System.out.println("Die Fläche muss größer als 0 sein");
		}
	}
	
	/*
	 * Liefert die Fläche des Kreises zurück
	 * @param die Fläche des Kreises
	 */
	public double getFlaeche () {
		
		return (Math.PI * Math.pow(radius, 2));
	}
	
	/*
	 * Gibt die Stringentsprechung des Kreises zurück. Ist der Radius beispielsweise gleich 1, so wird folgender String zurück gegeben:
	 * "r = 1.0, U = 6.283185307179586, F = 3.141592653589793"
	 */
	public String toString () {
		
		String ret = ("r = " + radius + ", U = " + (2 * Math.PI * radius) + ", F = " + (Math.PI * Math.pow(radius, 2)));
		return ret;
	}
	
	/*
	 * Erstellt ein Duplikat des Kreises auf den die Methode aufgerufen wird. Das Duplikat vom Typ Kreis wird zurück geliefert
	 * @return Duplikat vom Kreis
	 */
	public Kreis clone () {
		
		Kreis ret = new Kreis ();
		ret.setRadius(this.radius);
		return ret;
	}
	
	/*
	 * Kontrolliert ob der Kreis denselben Radius hat wie jener Kreis, welcher der Methode übergeben wird
	 * @param k - das zu vergleichende Objekt
	 * @return true, falls der Kreis und das übergebene Kreisobjekt denselben Radius haben
	 */
	public boolean equals (Kreis k) {
		
		boolean ret = this.radius == k.getRadius();
		return ret;
	}
	
	/*
	 * Kontrolliert, ob er Kreis kleiner als das übergebene Kreisobjekt k ist (Rückgabewert = -1), 
	 * größer (Rückgabewert = 1) oder gleich dem übergebenen Kreisobjekt k ist (Rückgabewert = 0)
	 * @param k - das zu vergleichende Objekt
	 * @return -1 falls das Objekt kleiner als das übergebene Objekt k ist
	 * 0 falls das Objekt gleich dem übergebenen Objekt k ist
	 * 1 falls das Objekt größer als das übergebene Objekt k ist
	 */
	public int compareTo (Kreis k) {
		
		int ret = 0;
		if (this.radius < k.getRadius()) {
			ret = -1;
		}
		else {
			if (this.radius == k.getRadius()) {
			ret = 0;
			}
			else {
				ret = 1;
			}
		}
		return ret;
	}
}
