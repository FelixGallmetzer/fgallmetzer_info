
public class Kartentrick
{

	public static void main(String[] args) {
		//@Author Felix

		do {
			 int[][]karten = null;
			karten = Kartentrick_Methoden.fuellen(karten, 0);
			
			Kartentrick_Methoden.ausgeben(karten);
			
			int spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			
			karten = Kartentrick_Methoden.fuellen(karten, spalte);
			
			Kartentrick_Methoden.ausgeben(karten);
			
			spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			
			karten = Kartentrick_Methoden.fuellen(karten, spalte);
			
			Kartentrick_Methoden.ausgeben(karten);
			
			spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			
			karten = Kartentrick_Methoden.fuellen(karten, spalte);
			
			Kartentrick_Methoden.ausgeben(karten);
			
			System.out.println("Karte " + karten[3][1] +
			" wurde gewählt");
			
			} while (Character.toLowerCase(
					TestScannerErweitert.readChar("Nochmals (j/n)? ")) == 'j');
	}

}
