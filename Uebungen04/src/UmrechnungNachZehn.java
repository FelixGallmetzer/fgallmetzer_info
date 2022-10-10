
public class UmrechnungNachZehn
{

	public static void main(String[] args) {
		//@Author Felix
		System.out.println("Umrechnung ins Zehnersystem");
		System.out.println("===========================");
		
		//Eingabe der Variablen
		int zzahl = 0;
		char zCh = 0;
		int exp = 0;
		int i = 0;
		int zahl = TestScanner.readInt("Geben Sie die Zahl ein: ");
		int base = TestScanner.readInt("Geben Sie die Basis ein: ");
		
		//Fehlermeldung für die Basis
		while (base >= 10 || base < 2) {
			System.out.println("Die Zahl muss zwischen 2 und 9 liegen");
			base = TestScanner.readInt("Geben Sie die Basis ein: ");
		}
		
		//Umrechnung
		String zS = String.valueOf(zahl);
		while (i<zS.length()) {
				exp =  zS.length() - 1 - i;
				zCh = zS.charAt(i);
				zzahl += (Integer.parseInt(String.valueOf(zCh))) * Math.pow(base, exp);
				i++;
		}
		
		//Ausgabe
		System.out.println();
		System.out.println("Die Zahl im Zehnersystem lautet " + zzahl);

	}

}
