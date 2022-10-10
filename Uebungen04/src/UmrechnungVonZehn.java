
public class UmrechnungVonZehn
{

	public static void main(String[] args) {
		//@Author Felix
		System.out.println("Umrechnung vom Zehnersystem");
		System.out.println("===========================");
		
		//Variablen
		int zahl = TestScanner.readInt("Bitte geben Sie die Zahl ein: ");
		int base = TestScanner.readInt("Bitte geben Sie die Basis ein: ");
		int i = 0;
		int [] r = {0,0,0,0,0,0,0};
		
		//Fehlermeldung Basis
		while (base >= 10 || base < 2) {
			System.out.println("Basis muss zwischen 2 und 9 liegen");
			base = TestScanner.readInt("Bitte geben Sie die Basis ein: ");
		}
		
		//Berechnung
		while (zahl > 0) {
			r[i] = zahl % base;
			i++;
			zahl = zahl / base;
		}
		
		//Ausgabe
		System.out.println();
		System.out.println("Die Zahl im " + base + "-er System lautet " + r[3] + r[2] + r[1] + r[0]);
	}
}
