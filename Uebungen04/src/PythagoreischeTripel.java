
public class PythagoreischeTripel
{

	public static void main(String[] args) {
		//@Author Felix
		
		//Variablen
		int a = 3;
		int b = 4;
		int c = 5;
		
		try {
			// Umleiten der Standardausgabe in die Datei welche unter dem angegebenen
			// Laufwerk und Pfad gespeichert wird. Ist die Datei dort nicht vorhanden,
			// wird sie angelegt
			System.setOut(new java.io.PrintStream("C:\\Users\\Felix\\Desktop\\Schule\\Info\\Excel\\PythagoreischeTripel.csv"));
			//Überschrift
			System.out.println("Pythagoreische Tripel\n Seite a; Seite b; Seite c;");
		
			//Die Zahlen werden ausgegeben
			while (a < 1000) {
				while (b < 1000) {
					while (c <= 1000) {
						if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a < b) {
							System.out.println(a + ";" + b + ";" + c + ";");
						}
						c++;
					}
					c = 5;
					b++;
				}
				b = 4;
				a++;
			}
		} catch (java.io.FileNotFoundException e) {
			// Es ist ein Fehler beim Erstellen oder Öffnen der Datei aufgetreten
			System.out.println("Fehler beim Erstellen der Datei");
		}
	}
}
