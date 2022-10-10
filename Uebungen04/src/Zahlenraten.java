
public class Zahlenraten
{

	public static void main(String[] args) {
		//@Author Felix
		
		System.out.println("Zahlenraten");
		System.out.println("===========");
		System.out.println("Ich habe mir eine Zahl im Intervall von [0,1000] ausgedacht. Versuchen Sie diese zu erraten");
		
		//Variablen
		int zahl = (int)(Math.random()*1000);
		int e = 0;
		boolean r = false;
		
		//Eingabe der Tipps und Feedback
		while (r == false) {
			e = TestScanner.readInt("Ihr Tipp: ");
			if (e > zahl) {
				System.out.println("Ihre Zahl ist zu groß");
			}
			
			if (e < zahl) {
				System.out.println("Ihre Zahl ist zu klein");
			}
			if (e == zahl) {
				System.out.println("Mein Kompliment! Sie haben die Zahl gefunden");
				r = true;
			}
		}
	}
}
