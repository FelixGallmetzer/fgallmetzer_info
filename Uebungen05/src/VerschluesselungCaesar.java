
public class VerschluesselungCaesar
{

	public static void main(String[] args) {
		//@Author Felix
		//Überschrift
		System.out.println("Verschlüsselung nach Caesar");
		System.out.println("===========================");
		
		//Variablen
		String t = "";
		char m = 'v';
		int v = 1;
		
		m = EingabenKontrolle.charKontrolle("V>erschlüsseln, E>ntschlüsseln, A>bbruch: ");
		do {
			//Eingabe
			t = EingabenKontrolle.stringKontrolle("Text: ");
			v = TestScannerErweitert.readInt("Verschiebung: ");
			
			//bei Verschlüsselung ist die Verschiebung positiv, bei Entschlüsselung negativ
			for(int i = 0; i < t.length(); i++) {
				//Leerzeichen werden herausgefiltert
				if(!Character.isWhitespace(t.charAt(i))) {
					//es wird eine Schleife des Alphabets gemacht
					if(Character.isLetter(t.charAt(i)+(v * (m == 'v' || m == 'V' ? 1 : -1) ))){
						System.out.print((char)(t.charAt(i)+(v * (m == 'v' || m == 'V' ? 1 : -1) )));
					} else {
						System.out.print((char)(t.charAt(i)+(v * (m == 'v' || m == 'V' ? 1 : -1) )-26 * (m)));
					}
				}				
			}
			System.out.println();
			m = EingabenKontrolle.charKontrolle("V>erschlüsseln, E>ntschlüsseln, A>bbruch: ");
		} while(m == 'v' || m == 'e' || m == 'V' || m == 'E');
	}
}
