public class ZahlenratenUmgekehrt
{
    public static void main(String[] args) {
    //@Author Felix
    	
    	//Variablen
    	System.out.println("Umgekehrtes Zahlenraten");
    	System.out.println("=======================");
    	System.out.println("Suche Sie sich eine Zahl im Intervall [0, 1000] aus. Ich werde sie finden");
    	int max = 1000;
    	int min = 0;
    	
    	//zufällige Zahl und 1. Tipp
    	int zahlr = (int) (Math.random() * max) + min;
    	System.out.println("Mein Tipp: " + zahlr);
    	int tipp = TestScanner.readInt("Zahl kleiner (0), größer (1), gefunden (2): ");

    	//Verarbeitung der Antwort
    	while (tipp != 2 && max - min != 0) {

    		if (tipp == 0) {
    			max = zahlr;
    		} 
            
    		else 
    			if (tipp == 1) {
    				min = zahlr;
    			}
            
    			//Fehlermeldung, falls die eingabe nicht zwischen 0 oder 2 liegt
    			else
    				while (tipp < 0 || tipp > 2) {
    					System.out.println("Die Zahl muss zwischen 0 und 2 liegen!");
    					tipp = TestScanner.readInt("Zahl kleiner (0), größer (1), gefunden (2): ");
    				}
         
    		int z = max - min + 1;

    		//Tipp
    		zahlr = (int) (Math.random() * z) + min;
    		System.out.println("Mein Tipp: " + zahlr);
    		tipp = TestScanner.readInt("Zahl kleiner (0), größer (1), gefunden (2): ");
    	}

    	//Gegen Schwindelversuche
    	if (max - min <= 0) {
    		System.out.println("Du Schwindler, Jetzt habe ich gewonnen.");
    	} 
    	//Zahl ist gefunden worden
    	else
    		System.out.println("Ich habe die Zahl gefunden!");
    }
}