
public class TextStatistik
{

	public static void main(String[] args) {
		//@Author Felix
		//Variablen
		System.out.println("TextStatistik");
		System.out.println("=============");
		int e = 0;
		String a = "";
		int b = 0;
		int c = 0;
		int d = 0;
		int f = 0;
		
		//Fehlermeldung und Texteingabe
		while (e == 0) {
			a = TestScannerErweitert.readString("Text: ");
			if (a.length() == 0) {
				System.out.println("Der Test muss mindestens ein Zeichen enthalten");
			}
			else {
				e = 1;
			}
		}
		//Bestimmungen der Buchstaben, Spaces, Zeichen und Selbstlauten
		for (int i = 0; i < a.length(); i++) {
			if (Character.isLetter(a.charAt(i))) {
				b++;
			}
		}
		for (int i = 0; i < a.length(); i++) {
			if (Character.isWhitespace(a.charAt(i))) {
				c++;
			}
		}
		for (int i = 0; i < a.length(); i++) {
			d++;
		}
		for (int i = 0; i < a.length(); i++) {
			switch(Character.toLowerCase(a.charAt(i))) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				f++;
			default:
			}
		}
		System.out.println("Selbslaute: " + f);
		System.out.println("Buchstabe: " + b);
		System.out.println("Leerzeichen: " + c);
		System.out.println("Zeichen: " + d);
	}
}


