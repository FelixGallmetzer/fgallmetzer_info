public class WortRatespiel
{

	public static void main(String[] args) {
		//@Author Felix
		
		//Überschrift
		System.out.println("Wortratespiel");
		System.out.println("=============");
		
		//erratener Teil
		String bekW = "";
		//wird gesucht
		String gesW = null;
		String e = null;
		int Versuche = 0;
		//Wiederholung
		char n = 'j';
		//Eingabe
		while(n == 'j') {
			gesW = EingabenKontrolle.stringKontrolle("Gesuchtes Wort: ");
			gesW = gesW.toUpperCase();
			//Umwandeln von Wort in Punkte
			for(int i = 0; i < gesW.length(); i++) {
				bekW = bekW + ".";
			}
			
			while(!bekW.equals(gesW)) {
				//Richtig Buchstaben werden ausgegeben
				System.out.println("Ihr Wort:       " + bekW);
				//Eingabe
				e = EingabenKontrolle.stringKontrolle("Buchstabe/Wort: ");
				//wird zu CAPS gemacht
				e = e.toUpperCase();
				Versuche++;
				
				 //Das eingegebene Wort wird mit dem Wort verglichen und die richtigen Buchstaben werden dann ersetzt.
				for(int i = 0; i < e.length(); i++) {
					for(int j = 0; j < bekW.length(); j++) {
						if(e.charAt(i) == gesW.charAt(j)) {
							bekW = bekW.substring(0, j) + e.charAt(i) + bekW.substring(j +1);
						}
					}
				}
			}
			System.out.println("Sie haben in " + Versuche + " Schritten das Wort erraten!");
			n = EingabenKontrolle.charKontrolle("Nochmal (j/n)? ");
			bekW = "";
		}
	}
}
