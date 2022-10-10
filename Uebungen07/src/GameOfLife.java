/**
 * importiert die Pakete java.awt und java.applet, damit im Applet die Klassen
 * Applet und Graphics verwendet werden können
 */
import java.awt.*;
import java.applet.*;

/**
 * Testapplet, welches zeigt wie Rechtecke und Linien in verschiedenen Farben auf
 * einer Zeichenfläche im Applet ausgegeben werden können.
 * ACHTUNG: Java-Applets müssen anders gestartet werden als normale Java-Programme
 * @author Michael Wild
 *
 * Die Klasse TestGrafikAusgabe ist von der Klasse Applet abgeleitet und erbt somit
 * alle Eigenschaften, die ein Applet hat. Durch die Ableitung (Vererbung) wird die
 * Klasse TestGrafikAusgabe zum Applet
 */
public class GameOfLife extends Applet {
	
	// Fixe Anzahl von Zeilen und Spalten
	static final int ANZAHL_ZEILEN = 31;
	static final int ANZAHL_SPALTEN = 31;
	// Maximale Anzahl von Iterationsschritten
	static final int MAX_SCHRITTE = 150;

	/*
	 * Es wird ein boolean-Array, welches schwarze
	 * Blöcke für true und graue Blöcke für false
	 * ausgibt.
	 * @param g Das Graphic auf das gezeihcnet wird
	 * @param Die Breite des Applets
	 * @param Die Höhe des Applets
	 * @param Die Matrix, die ausgegeben wird
	 */
	public static void ausgebenMatrix(Graphics g, int breite, int hoehe, boolean[][] matrix) {
		//@Author Felix
		
		for(int i = 0; i < ANZAHL_ZEILEN; i++) {
	    for(int j = 0; j < ANZAHL_SPALTEN; j++) {
	    	
	    	if(matrix[i][j] == true) {
	    		g.setColor(Color.black);
	    		
	    	}
	    	else {
	    		g.setColor(Color.gray);
	    		}
	    	
	    	g.fillRect(j * breite/ANZAHL_ZEILEN, i * (hoehe/ANZAHL_SPALTEN), breite / ANZAHL_ZEILEN - 1, hoehe / ANZAHL_SPALTEN - 1);
	    }
    }
	}
	
	/*
	 * Die übergebene Matrix wird mit einem Stern, welcher gs groß ist gefüllt.
	 * Ist gr 0, dann wird nur ein Punkt in der Mitte ausgefüllt.
	 * @param Die Größe des Sterns
	 * @param Die Matrix, welche verändert wird
	 * @return Veränderte Matrix
	 */
	public static boolean[][] fuellenMatrixSternMitte(int gr, boolean[][] matrix) {
	//@Author Felix
		
		boolean[][] ret = matrix;
		ret[ANZAHL_ZEILEN / 2] [ANZAHL_SPALTEN / 2] = true;
		
		if(gr > 0) {
			
			for (int i = 1; i <= gr; i++) {
				
				ret[ANZAHL_ZEILEN / 2] [ANZAHL_SPALTEN / 2 - i] = true;
				ret[ANZAHL_ZEILEN / 2 - i] [ANZAHL_SPALTEN / 2] = true;
				ret[ANZAHL_ZEILEN / 2] [ANZAHL_SPALTEN / 2 + i] = true;
				ret[ANZAHL_ZEILEN / 2 + i] [ANZAHL_SPALTEN / 2] = true;
			}
		}
		return ret;
	}
	
	/*
	 * Gibt die ANzahl von benachbarten Elementen
	 * mit dem wert true zurück
	 * @param Die Zeile der Position des Elements
	 * @param Die Spalte der Position des Elements
	 * @param Matrix
	 * @return Anzahl der benachbarten Elemente
	 */
	public static int anzahlLebendeNachbaren(int zeile,int spalte,boolean[][]matrix) {
	//@Author Felix
		
		int ret = 0;
		
		for(int i = -1; i < 2; i++) {
			
			for (int j = -1; j < 2; j++) {
				
				if (zeile - 1 >= 0 && spalte - 1 >= 0 && zeile + 1 <= ANZAHL_ZEILEN - 1 && spalte + 1 <= ANZAHL_SPALTEN - 1) {
					
					if(matrix [zeile + i] [spalte + j] == true && (j != 0 || i != 0)) {
						ret++;
					}
				}
			}
		}
		return ret;
	}
	
	/*
	 * Diese Methode verwendet die vorige Methode,
	 * um einen neuen Lebenszyklus für die ihr
	 * übergebene Matrix zu berechnen. Das neu
	 * berechnete Leben wird in einer neuen Matrix
	 * zurück geliefert. Dabei wird die alte Matrix nicht geändert.
	 * @param Vorgänger der Matrix
	 * @return Neu berechnete Matrix
	 */
	public static boolean[][] berechneMatrix(boolean[][] matrix) {
	//@Author Felix
		
		boolean[][] ret = new boolean[ANZAHL_ZEILEN] [ANZAHL_SPALTEN];
		
		for (int i = 0; i < ANZAHL_ZEILEN; i++) {
			
			for (int j = 0; j < ANZAHL_SPALTEN; j++) {
				
				int z = anzahlLebendeNachbaren(i, j, matrix);
				
				if(matrix [i][j] == true && z > 1 && z < 4) {
					ret [i][j] = true;
					
				}
				else if (matrix [i][j] == false && z == 3) {
					ret [i][j] = true;
				}
			}
		}
		return ret;
	}
	
	/*
	 * Diese Methode kontrolliert ob die beiden ihr übergebenen Matrizen unterschiedlich sind oder nicht. Sie
	 * liefert true zurück, falls die Matrizen an unterschiedlichen Stellen gefüllt sind.
	 * @param erste matrix
	 * @param zweite matrix
	 * @return Unterschiede oder nicht
	 */
	public static boolean existierenUnterschiede(boolean[][] matrix1, boolean[][] matrix2) {
	//@Author Felix
		
		boolean ret = false;
		
		for (int i = 0; i < ANZAHL_ZEILEN; i++) {
			
			for (int j = 0; j < ANZAHL_SPALTEN; j++) {
				
				if(matrix1 [i][j] != matrix2 [i][j]) {
					
					ret = true;
					i = ANZAHL_ZEILEN;
					j = ANZAHL_SPALTEN;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Veranlasst dass das Programm millis Millisekunden pausiert
	 * @param millis Anzahl der Millisekunden die gewartet werden
	 */
	public void bremse(int millis) {
		//@Author Felix
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	
	/*
	 * Die Matrix bekommt an zufälligen Stellen den Wert "true".
	 * Man kann der Methode auch angeben, wie das Verhältnis zwisschen lebenden und
	 * nicht lebeneden Positionen sein soll. Beispielsweise wird bei 0.1 10% der Positionen
	 * mit leben gefüllt.
	 * @param Vorherige Matrix
	 * @param Verhältnis der Positionen
	 * @return Veränderte Matrix
	 */
	public static boolean[][] fuellenMatrixZufaellig(boolean[][] matrix, double v) {
	//@Author Felix
		
		boolean[][] ret = matrix;
		
		for (int i = 0; i < (v * ANZAHL_SPALTEN * ANZAHL_ZEILEN); i++){
			
			int z1 = (int) (Math.random() * ANZAHL_ZEILEN);
			int z2 = (int) (Math.random() * ANZAHL_SPALTEN);
			
			if(ret[z1] [z2] == false) {
				ret[z1] [z2] = true;
				
			}
			else {
				i--;
			}
		}
		return ret;
	}
	
	/* 
	 * Gibt ein Applet aus, wobei man das Spiel des Lebens beobachten kann.
	 */	
	
	public void paint(Graphics g) {
	//@Author Felix
		
		System.out.println("start");
		
    int h = getHeight();
		int b = getWidth();
    
    boolean[][] m1 = new boolean[ANZAHL_ZEILEN] [ANZAHL_SPALTEN];
    boolean[][] m2 = new boolean[ANZAHL_ZEILEN] [ANZAHL_SPALTEN];
     
    m1=fuellenMatrixSternMitte(14,m1);
    
    int s = 0;
    do {
    	ausgebenMatrix(g , b, h, m1);
    	
    	m2 = m1;
    	m1 = berechneMatrix(m2);
    	
    	bremse(10);
    	s++;
    	
    } while(existierenUnterschiede(m1, m2) && s < MAX_SCHRITTE);
  }
}
