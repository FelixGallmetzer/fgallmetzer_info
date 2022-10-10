
public class DreieckEigenschaften
{

	public static void main(String[] args) {
		//@Author Felix
		
		//Variablen
		double a = 0;
		double b = 0;
		double c = 0;
		final double EPSILON = 1E-10;
		int ak = 0;	
		double a2 = Math.pow(a, 2);
		double b2 = Math.pow(b, 2);
		double c2 = Math.pow(c, 2);
		
		//Überschrift
		System.out.println("Eigenschaften eines Dreiecks");
		System.out.println("============================");
		
		//Einlesen von Variablen
		while (ak == 0) {
			a = TestScanner.readDouble("Seite A: ");
			b = TestScanner.readDouble("Seite B: ");
			c = TestScanner.readDouble("Seite C: ");
			double abc = a + b + c;
			
			//Bestimmung ob unmöglich
			if ((b + c) < a || (a + c) < b || (a + b) < c) {
				System.out.println("Unmögliches Dreieck");
			}
			
			else {
				System.out.println("Umfang: " + abc);
				System.out.println("Fläche: " + Math.sqrt((abc * 0.5) * ((abc * 0.5) - a) * ((abc * 0.5) - b) * ((abc * 0.5) - c)));
				
				//Bestimmung ob  gleichseitig
				if(a == b && a == c) {
					System.out.println("Gleichseitiges Dreieck");
				}
				
				//Bestimmung ob gleichschenklig
				if (a == b || a == c || b == c) {
					System.out.println("Gleichschenkliges Dreieck");
				}
				
				//Bestimmung ob pythagoreisch
				if(b2 + c2 == a2) {
					if(a - (int) a < EPSILON && b - (int) b < EPSILON && c - (int) b < EPSILON) {
						System.out.println("Pythagoreisches Dreieck");
						System.out.println("Hypotenuse: " + Math.sqrt(a2 + c2));
					}
					else {
						//Bestimmung ob rechtwinklig
						System.out.println("Rechtwinkliges Dreieck");
						System.out.println("Hypotenuse: " + Math.sqrt(a2 + c2));
					}
				}
			}
			//Frage ob nochmal
			ak = TestScanner.readInt("Nochmal (0), Beenden (1): ");
		}

	}

}
