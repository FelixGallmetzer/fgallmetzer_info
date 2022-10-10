public class MeinZahlensystemwandler
{
	/**
	 * Wandelt das Zeichen nr in eine Zahl um, wobei die Gro�-/Klein-schreibung 
	 * ignoriert wird:
	 * '0' ergibt 0, '1' ergibt 1, ... '9' ergbit 9, 'A' ergibt 10, 'B' ergibt 11, ...,
	 * 'Z' ergibt 35
	 * Sollte ein ung�ltiges Zeichen �bergeben werden, so gibt die Methode -1 zur�ck
	 * @param nr das umzuwandelnde Zeichen
	 * @return die Zahl f�r die das Zeichen steht
	 */
	public static int getDigit (char nr) {
		//@Author Felix
		//Variablen
		int ret = -1;
		
		//falls der nr eine Zahl ist
		if(Character.isDigit(nr)) {
			ret = nr - 48;
		}
		
		//falls der nr ein Buchstabe ist
		if(Character.isLetter(nr)) {
			nr = Character.toUpperCase(nr);
			ret = nr - 55;
		}
		
		return ret;
	}
	
	/**
	 * Wandelt die Nummer der Ziffer nr in ein Zeichen um:
	 * 0 ergibt '0', 1 ergibt '1', ..., 9 ergibt '9', 10 ergibt 'A', 11 ergibt 'B', 
	 * ..., 35 ergibt 'Z'
	 * Sollte eine ung�ltige Nummer �bergeben werden, so gibt die Methode einen Stern 
	 * '*' zur�ck
	 * @param nr die Nummer welche in ein Zeichen umgewandelt werden soll
	 * @return das Zeichen das f�r die Nummer steht
	 */
	public static char getDigit (int nr) {
		//@Author Felix
		//Variablen
		char ret = '*';
		int a = 0;
		boolean r = true;
		
		if (nr > 35) {
			r = false;
			ret = '*';
		}
		
		//wenn nr kleiner als 10 ist wird eine Nummer zurück gegeben
		if (nr < 10) {
			a = nr + 48;
			ret = (char) a;
		}
		
		//wenn nr zwischen 10 und 35 ist wird ein Buchstabe zurück gegeben
		if (nr >= 10 && nr <= 35) {
			a = nr + 55;
			ret = (char) a;
		}
		
		return ret;
	}
	
	/**
	 * Wandelt die Zahl num mit der Basis basis in eine Dezimalzahl um und liefert
	 * diese zur�ck. Falls die �bergebene Zahl num gleich null oder deren L�nge gleich
	 * 0 ist oder die Basis kleiner als 2 ist, wird -1 zur�ck geliefert. Wenn eine
	 * Ziffer der �bergebenen Zahl nicht zur Basis passt, wird ebenfalls -1 zur�ck
	 * geliefert
	 * Beispiel: numToDec("01110110", 2) ergibt 118
	 * numToDec("170712", 8) ergibt 61898
	 * numToDec("170712", 7) ergibt -1
	 * @param num die umzuwandelnde Zahl als String �bergeben
	 * @param basis die Basis der umzuwandelnden Zahl
	 * @return das Ergebnis im Dezimalsystem
	 */
	public static int numToDec (String num, int basis) {
		//@Author Felix
		//Variablen
		int ret = -1;
		boolean r = true;
		int i = 0;
		
		//falls eine der eingegeben zahlen umgewandelt größer/gleich wie die basis ist
		while (i < num.length()) {
			if (num.charAt(i) - 48 >= basis) {
				r = false;
			}
			i++;
		}
		
		//Anforderungen werden überprüft
		if (basis <= 1 || num.equals(null) || num.length() <= 0) {
			r = false;
		}
		
		//Berechnungen + Ruckgabe
		if (r) {
			int d = 0;
			int sum = 0;
			i = num.length() - 1;
			
			while (i >= 0) {
				sum += (int)((num.charAt(i) - 48) * Math.pow(basis, d));
				d++;
				i--;
			}
			ret = sum;
		}
		return ret;
	}
	
	/**
	 * Wandelt die Dezimalzahl dec in eine Zahl mit der Basis basis um und gibt diese
	 * zur�ck. Dabei muss die Dezimalzahl dec gr��er oder gleich 0 sein und die Basis
	 * muss gr��er als 1 sein, ansonsten wird null zur�ck geliefert.
	 * Beispiel: decToNum(118,2) ergibt 1110110
	 * decToNum(61898,8) ergibt 170712
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @param basis nach welcher umgewandelt wird
	 * @return die umgewandelte Zahl
	 */
	public static String decToNum(int dec, int basis) {
		//@Author Felix
		//Variablen
		String ret = null;
		boolean r = true;
		
		//Anforderungen werden überprüft
		if (basis <= 1 || dec < 0) {
			r = false;
		}
		
		if (r) {
			ret="";
			
			while (dec > 0) {
				ret += dec % basis;
				dec = dec / basis;
			}
			ret = MeinStringAnalysierer.umdrehenString(ret);
		}
		return ret;
	}
	
	/**
	 * hex wird von einer Hexadezimalzahl in eine Dezimalzahl umgewandelt und zurückgegeben.
	 * Falls hex null ist, wird null zurückgegeben.
	 * Bsp.: 	hexToDec(130) = 304
	 * 				hexToDec(A5) = 165
	 * @param hex; die umzuwandelnde Zahl
	 * @return das Ergebnis
	 */
	public static int hexToDec (String hex) {
		//@Author Felix
		//Variablen
		int ret = 0;
		int n = 0;
		int a = hex.length()-1;
		int i = 0;
		
		if (!hex.equals(null)) {
			while (i<hex.length()) {
				
				//wenn hex zwischen 48 und 57 ist wird n definiert
				if (hex.charAt(i) >= 48 && hex.charAt(i) <= 57) {
					n=(hex.charAt(i))-48;
				}
				
				//wenn hex zwischen 65 und 70 ist wird n definiert
				if(hex.charAt(i) >= 65 && hex.charAt(i) <= 70) {
					n=(hex.charAt(i)) - 55;
				}
				
				ret += n * (int) Math.pow(16, a);
			  a--;
			  i++;
			}
		}
		return ret;
	}
	
	/**
	 * dec wird von einer Dezimalzahl in eine Hexadezimalzahl umgewandelt und zurückgegeben.
	 * dec muss größer oder gleich 0 sein, ansonsten wird null zur�ck geliefert.
	 * Beispiel: 	decToHex(304) ergibt 130
	 * 						decToHex(165) ergibt A5
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @return die umgewandelte Zahl
	 */
	public static String decToHex(int dec) {
		//@Author Felix
		//Variablen
		String ret=null;
		boolean r = true;
		
		//Anforderungen werden überprüft
		if (dec < 0) {
			ret = null;
			r = false;
		}
		
		//ist dec 0 so wird "" zurückgegeben
		if (r) {
			ret="";
			
			while (dec > 0) {
				
				if (dec % 16 >= 10) {
					ret += (char) (dec % 16 + 55);
					dec /= 16;
					
				} else {
					ret += dec % 16;
					dec /= 16;
				}
			}
			ret = MeinStringAnalysierer.umdrehenString(ret);
		}
		return ret;
	}
	
	/**
	 * Die Binärzahl dual wird in eine Dezimalzahl umgewandelt und zurückgegeben
	 * Dabei darf die dual nicht null sein, ansonsten wird -1 zur�ck geliefert.
	 * Beispiel: 	dualToDec(1110011) ergibt 115
	 * 						dualToDec(101) ergibt 5
	 * @param dual die umzuwandelnde Zahl
	 * @return umgewandelte Zahl
	 */
	public static int dualToDec(String dual) {
		//@Author Felix
		//Variablen
		int ret = 0;
		int p = 0;
		boolean r = true;
		int i = 0;
		
		//Anforderungen werden überprüft
		if (dual == null) {
			ret = -1;
			r = false;
		} else {
			p = dual.length() -1;
		}
		
		if (r) {
			
			while (i < dual.length()) {
				ret += (dual.charAt(i) - 48) * (int) Math.pow(2, p);
				p--;
				i++;
			}
		}
		
		return ret;
	}
	
	/**
	 * Die Dezimalzahl dec in eine Binärzahl umgewandelt und zurückgegeben
	 * Die Dezimalzahl dec muss gr��er oder gleich als 0 sein, ansonsten wird null zur�ck geliefert.
	 * Beispiel: 	decToDual(115) ergibt 1110011
	 * 						decToDual(5) ergibt 101
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @return umgewandelte Zahl
	 */
	public static String decToDual(int dec) {
		//@Author Felix
		//Variablen
		String ret = null;
		boolean r = true;
		
		//Anforderungen werden überprüft
		if (dec != 0 && dec < 0) {
			r = false;
		}
		
		if (r) {
			ret= "";
			
			if (dec == 0) {
				ret += 0;
			}
			
			//dem String werden 1en und 0en hinzugefügt
			while (dec > 0) {
				ret += dec % 2;
				dec /= 2;
			}
			ret = MeinStringAnalysierer.umdrehenString(ret);
		}
		return ret;
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * @param die umzuwandelnde Zahl
	 * @return umgewandelte Zahl
	 */
	public static String numToNum(String zahl,int num1,int num2) {
		//@Author Felix
		//Variablen
		String ret = null;

		return ret;
	}
	
}