
public class VerschlüsselungDrehen
{

	public static void main(String[] args) {
		// @Author Felix
		// Variablen
		int e = 0;
		int j = 0;
		String a = "";
		int i = 0;

		// Fehlermeldung bei ungültiger Eingabe
		while (e == 0) {
			a = TestScannerErweitert.readString("Text: ");
			if (a.length() == 0) {
				System.out.println("Der Test muss mindestens ein Zeichen enthalten");
			} else {
				e = 1;
			}
			j = a.length() - 1;
		}
		// Verschlüsselung
		if (j % 2 != 0) {
			for (i = 0; i < a.length() / 2; i++) {
				System.out.print(a.charAt(i));
				System.out.print(a.charAt(j - i));
			}
			j = a.length() - 1;
			i = 0;
		} else {
			//wenn es nicht gerade ist, dann wird dies hier ausgegeben
			for (i = 0; i < (a.length() / 2) + 1; i++) {
				System.out.print(a.charAt(i));

				if (j > a.length() / 2) {
					System.out.print(a.charAt(j));
					j--;
				}
			}
		}
	}
}
