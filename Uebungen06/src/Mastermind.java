public class Mastermind {

	public static void main(String[] args) {
		//@Author Felix
		//Variablen
		int S = 4;
		int Vs = 0;
		String c = "";
		String t = "";
		int f = 0;
		
		//Überschrift
		System.out.println("Mastermind");
		System.out.println("==========");
		f = TestScannerErweitert.readInt("Anzahl Farben: ");
		
		while (c != "ENDE") {			
			System.out.print("=====================> ");
			c = erzeugeCode(S, f);

			//tipp wird eingegeben
			while (!t.equals("ENDE") && ermittleSchwarz(c, t) != S) {
				t = eingabeTipp(S);
				
				//Weiß bzw. Schwarz wird ausgegeben
				if (!t.equals("ENDE")) {
					Vs++;
					System.out.print(Vs + "): " + t + " = (w: " + ermittleWeiss(c, t)
							+ ", s: " + ermittleSchwarz(c, t) + "): ");
					
					//erraten?
					if (ermittleSchwarz(c, t) == S)
						System.out.println("Code gefunden");
				}
			}
		}
	}
	
	/*
	 * Anhand dieser Methode wird die Anzahl der Stellen des Codes und die Anzahl der Farben übergeben. Sie liefert
	 * den zufällig ermittelten Code zurück, wobei anstelle von Farben Großbuchstaben von A beginnend
	 * zurückgeliefert werden. Die Methode sorgt dafür, dass im Code keine doppelten Farben bzw. Buchstaben
	 * vorhanden sind. Die Methode liefert nur dann ein Ergebnis ungleich null zurück, falls die Farbenanzahl
	 * größer oder gleich der Stellenanzahl ist. Die Methode darf keine Bildschirmausgabe machen. Wird der
	 * Methode als Stellenanzahl 4 und als Farbenanzahl 6 übergeben, so kann sie beispielsweise den Text
	 * "ACFD" zurück liefern. 
	 * @param int nS ist aus wieviel Zeichen der Farbcode besteht.
	 * @param nF aus wievielen verschiedenen Farben er besteht.
	 * @return Farbcode als String
	 */
	
	public static String erzeugeCode(int nS, int nF) {
		//@Author Felix
		//Variablen
		String ret = "";
		int i = 0;
		int j = 0;
		
		if (nF > nS) {
			while (nS > i) {
				char ad = (char)((int) (Math.random() * nF - 0.5) + 65);
				
				while (j < ret.length()) {
					while (ad == ret.charAt(j)) {
						ad = (char)((int) (Math.random() * nF - 0.5) + 65);
						j = 0;
					}
					j++;
				}
				
				ret += ad;
				i++;
			}
			
		} else
			ret = null;
		
		return ret;
	}
	/*
	 * Anhand dieser Methode wird ein String übergeben, und sie kontrolliert, ob im String Buchstaben doppelt
	 * vorkommen. Ist das der Fall, so wird true zurück geliefert. Die Methode liefert immer dann false
	 * zurück, falls der übergebene String null oder die Länge des Strings gleich 0 ist. Bei der Kontrolle auf
	 * doppelte Buchstaben wird die Groß-/Kleinschreibung nicht beachtet. In der Methode selbst dürfen keine
	 * Bildschirmausgaben erfolgen. Wird der Methode beispielsweise der String "ACFD" übergeben so wird
	 * false zurück geliefert, wird "ACAD" übergeben, so wird true zurück geliefert.
	 * @param String, welcher überprüft wird
	 * @return true oder false; ob doppelte Zeichen enthalten sind
	 */
	
	public static boolean enthaeltDoppelte(String code) {
		//@Author Felix
		//Variablen
		boolean ret = false;
		code = code.toUpperCase();
		boolean r = true;
		if (code.length() <= 0 || code == null) {
			ret = false;
			r = false;
		}
		
		if (r) {
			for (int j = 0; j < code.length() - 1; j++) {
				
				for (int i = j + 1; i < code.length(); i++) {
					
					if (code.charAt(j) == code.charAt(i)) {
						
						ret = true;
						i = code.length();
						j = code.length();
					}
				}
			}
		}
		
		return ret;
	}
	/*
	* Durch diese Methode wird dem Benutzer die Möglichkeit gegeben, seinen Tipp einzugeben. Wie lang der
	* einzugebende Tipp sein darf, wird der Methode übergeben. Der vom Benutzer eingegebene Tipp wird
	* von der Methode zurück geliefert. Innerhalb der Methode wird der Text "Ihr Tipp:" ausgegeben. Die
	* Eingabe muss in der Methode automatisch wiederholt werden, falls der Benutzer keinen Tipp eingibt, der
	* Tipp nicht die geforderte Länge hat und falls doppelte Buchstaben im Tipp vorhanden sind. Gibt der
	* Benutzer den Text "ende" ein, so muss die Eingabe abgebrochen und der eingegebene Text zurück
	* geliefert werden. Der eingegebene Text muss in Großbuchstaben konvertiert und zurückgegeben
	* werden. 
	* @param int laenge
	* @return der Tipp
	*/
	public static String eingabeTipp(int laenge) {
		//@Author Felix
		//Variablen
		String ret = "";
		
		while (!ret.equals("ENDE") && (ret == "" || enthaeltDoppelte(ret) || ret == null)) {
			
			ret = TestScannerErweitert.readString("Ihr Tipp: ");
			ret = ret.toUpperCase();
			
			if (!ret.equals("ENDE") && (ret == "" || enthaeltDoppelte(ret) || ret == null)) {
				System.out.println("die Eingabe entspricht nicht den Anforderungen");
			}
		}
		
		return ret;
	}
		/*
		* Anhand dieser Methode soll ermittelt werden wie viele Buchstaben sich am richtigen Platz befinden.
		* Dazu werden der Methode der zu erratende Code und der Tipp übergeben. Die Methode liefert die
		* Anzahl der Richtigen zurück. Der übergebene Code und der Tipp müssen gefüllt sein und dieselbe Länge
		* haben, ansonsten wird -1 zurück geliefert. Wird der Methode beispielsweise "ABCD" und "BACF"
		* übergeben, so liefert sie 1 zurück. 
		* @param code zu erratener Code
		* @param tipp eingegebener Code
		* @return anzahl von Farben welche an richtiger Position sind
	 */
	public static int ermittleSchwarz(String code, String tipp) {
		//@Author Felix
		//Variablen
		int ret = 0;
		int i = 0;
		
		if (code.length() == tipp.length()) {
			
			while (i < code.length()) {
				
				if (tipp.charAt(i) == code.charAt(i)) {
					ret++;
				}
				
				i++;
			}
			
		} else {
			ret = -1;
		}
		
		return ret;
	}
	/*
	* Diese Methode soll die Anzahl der richtigen Buchstaben, die sich noch am falschen Platz befinden,
	* ermitteln. Dabei werden wiederum der zu erratende Code und der Tipp übergeben. Die Methode liefert
	* wiederum die Anzahl der Richtigen Buchstaben zurück. Der übergebene Code und der Tipp müssen
	* gefüllt sein und dieselbe Länge haben, ansonsten wird -1 zurück geliefert. Wird der Methode
	* beispielsweise "ABCD" und "BACF" übergeben, so liefert sie 2 zurück. 
	* @param code zu erratener Code
	* @param tipp der eingegebene Code
	* @return Farben welche im code vorhanden sind
	*/

	public static int ermittleWeiss(String code, String tipp) {
		//@Author Felix
		//Variablen
		int ret = 0;
		
		if (code.length() == tipp.length()) {
			
			for (int j = 0; j < code.length(); j++) {
				
				for (int i = 0; i < tipp.length(); i++) {
					
					if (tipp.charAt(i) == code.charAt(i))
						ret++;
				}
			}
			
		} else {
			ret = -1;
		}
		
		return ret;
	}
}