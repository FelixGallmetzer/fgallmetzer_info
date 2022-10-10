
public class Quadrat
{
	private double seiteA = 0;
	
	/*
	 * Setzt die Länge der Seite A. Wird nur gesetzt solange der eingegebene Wert größer oder gleich wie 0 ist.
	 * @param seiteA - Die zu setzende Länge
	 */
	public void setSeiteA (double seiteA) {
		
		if (seiteA > 0) {
			this.seiteA = seiteA;
		}
		else {
			System.out.println("Die Seite darf nicht kleiner als 0 sein");
		}
	}
	
	/*
	 * Gibt den Länge der Seite A zurück
	 * @return Länge der Seite A
	 */
	public double getSeiteA () {
		
		return seiteA;
	}
	
	/*
	 * Setzt die Länge der Seite B. Wird nur gesetzt falls die Länge >= 0 ist.
	 * @param seiteB - Die zu setzende Länge
	 */
	public void setSeiteB (double seiteB) {
		
		if (seiteB > 0) {
			this.seiteA = seiteB;
		}
		else {
			System.out.println("Die Seite darf nicht kleiner als 0 sein");
		}
	}
	
	/*
	 * Gibt die Länge der Seite B zurück
	 * @return Länge der Seite B
	 */
	public double getSeiteB () {
		
		return seiteA;
	}
	
	/*
	 * Setzt den Umfang des Quadrats. Der Umfang wird nicht gesetzt, falls er kleiner als 0 ist.
	 * @param umfang - der zu setzende Umfang
	 */
	public void setUmfang (double umfang) {
		
		if (umfang >= 0) {
			seiteA = umfang/4;
		}
		else {
			System.out.println("Der Umfang darf nicht kleiner als 0 sein");
		}
	}
	
	/*
	 * Gibt den Umfang des Quadrats zurück
	 * @return Umfang des Quadrats
	 */
	public double getUmfang () {
		
		return seiteA * 4;
	}
	
	/*
	 * Setzt die Fläche des QUadrats. DIe Fläche wird nicht gesetzt, falls sie kleiner als 0 ist.
	 * @param flaeche - die zu setzende Fläche
	 */
	public void setFlaeche (double flaeche) {
		
		if (flaeche >= 0) {
			seiteA = Math.sqrt(flaeche);
		}
		else {
			System.out.println("Die Fläche darf nicht kleiner als 0 sein");
		}
	}
	
	/*
	 * Gibt die Fläche des Quadrats zurück
	 * @return Fläche des Quadrats
	 */
	public double getFlaeche () {
		
		return Math.pow(seiteA, 2);
	}
	
	/*
	 * Gibt die Stringentsprechung des Quadrats zurück. Ist die Seite Abeispielsweise gleich 3.5, so wird folgender String zurück gegeben:
	 * "a = 3.5, b = 3.5, U = 14.0, f = 12.25"
	 */
	public String toString () {
		
		String ret = ("a = " + seiteA + ", b = " + seiteA + ", U = " + (seiteA * 4) + ", F = " + (Math.pow(seiteA, 2)));
		return ret;
	}
	
	/*
	 * Erstellt ein Duplikat des Quadrats auf welchem die Methode aufgerufen wurde.
	 * @return Duplikat des Quadrats
	 */
	public Quadrat clone () {
		
		Quadrat ret = new Quadrat ();
		ret.setSeiteA(this.seiteA);
		return ret;
	}
	
	/*
	 * Kontrolliert ob das Quadrat und das übergebene Quadrat die gleiche Seitenlänge haben
	 * @param q - Quadrat mit welchem verglichen werden soll
	 * @return true oder false, ob sie gleich lang sind oder nicht
	 */
	
	public boolean equals (Quadrat q) {
		
		boolean ret = this.seiteA == q.seiteA;
		return ret;
	}
	
	/*
	 * Kontrolliert ob die länge des Quadrats gleich groß (0), kleiner (-1) oder größer (1) als das 
	 * übergebene Quadrat ist
	 * @param q - zu vergleichendes Quadrat
	 * @return -1 falls das Objekt kleiner als das übergebene Objekt q ist
	 * 0 falls das Objekt gleich dem übergebenen Objekt q ist
	 * 1 falls das Objekt größer als das übergebene Objekt q ist
	 */
	public int compareTo (Quadrat q) {
		
		int ret = 0;
		if (this.seiteA < q.getSeiteA()) {
			ret = -1;
		}
		else {
			if (this.seiteA == q.getSeiteA()) {
				ret = 0;
			}
			else {
				ret = 1;
			}
		}
		return ret;
	}
}
