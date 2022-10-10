
public class ZeichensatzAnalyse
{

	public static void main(String[] args) {
		//@Author Felix
		//Variablen
		int b = 0;
		char zeichen = 32;
		
		//Ausgabe mit Unterteilungen
		System.out.println("IsLetter");
		while (zeichen<=255) {
			if (Character.isLetter(zeichen)) {
				System.out.print(zeichen + " ");
				b++;
			}
			//Absatz
			zeichen++;
			if (b == 30) {
				System.out.println();
				b = 0;
			}
		}
			zeichen = 32;
			b = 0;
			
			System.out.println("\nIsWhitespace");
			while (zeichen<=255) {
				if (Character.isWhitespace(zeichen)){
					System.out.print((int)zeichen + " ");
					b++;
				}
				zeichen++;
				if (b == 30) {
					System.out.println();
					b = 0;
				}
			}
			zeichen = 32;
			b = 0;
			
			System.out.println("\nIsLowerCase");
			while (zeichen<=255) {
				if (Character.isLowerCase(zeichen)) {
					System.out.print(zeichen + " ");
					b++;
				}
				zeichen++;
				if (b == 30) {
					System.out.println();
					b = 0;
				}
			}
			zeichen = 32;
			b = 0;
			
			System.out.println("\nIsUpperCase");
			while (zeichen<=255) {
				if (Character.isUpperCase(zeichen)) {
					System.out.print(zeichen + " ");
					b++;
				}
				zeichen++;
				if (b == 30) {
					System.out.println();
					b = 0;
				}
			}

	}

}
