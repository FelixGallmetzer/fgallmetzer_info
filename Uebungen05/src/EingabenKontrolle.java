public class EingabenKontrolle
{

	public static void main(String[] args) {
		//@Author Felix
		String kS = null;
		char kCh = 32;
		kS = stringKontrolle("Bitte geben Sie den zu kontrollierenden String ein: ");
		System.out.println("Ihre Eingabe ist in Ordnung");
		kCh = charKontrolle("Bitte geben Sie den zu kontrollierenden Char ein: ");
		System.out.println("Ihre Eingabe ist in Ordnung");
	}
	
	public static String stringKontrolle(String output) {
		boolean  e = false;
		String ret = null;	
		//String wird gelesen wenn nicht Buchstabe ist wird Fehlermeldung ausgegeben
		while(!e) {
			ret = TestScannerErweitert.readString(output);
			for(int i=0; i<ret.length();i++) {
				if(!Character.isLetter(ret.charAt(i))) {
					System.out.println("Bitte geben Sie einen Buchstaben ein");
					e = false;
					i = ret.length();
				} else {
					e = true;
				}
			}
		}
		return ret;
	}
	
	public static char charKontrolle(String output) {
		char ret = 32;
		boolean  e = false;
		//Char wird gelesen Buchstabe ist wird Fehler ausgegeben
		while(!e) {
			ret = TestScannerErweitert.readChar(output);
			if(Character.isLetter(ret))
				e = true;
			else {
				System.out.println("Bitte geben Sie einen Buchstaben ein");
			}
		}
		return ret;
	}
}
