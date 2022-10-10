
public class ISOLatin1Zeichensatz
{

	public static void main(String[] args) {
		//@Author Felix
		
		//Variablen werden definiert
		int i = 32;
		int b = 39;
		char zeichen = 32;
		
		//Ausgabe mit Leerzeichen
		while (i<=255) {
			if (i < 100) {
			System.out.print(i + " " + zeichen + "  ");
			}
			if (i >= 100) {
			System.out.print(i + " " + zeichen +" ");
			}
			if (i == b) {
			System.out.println();
			b += 8;
			}
			i++;
			zeichen++;
		}
	}
}
