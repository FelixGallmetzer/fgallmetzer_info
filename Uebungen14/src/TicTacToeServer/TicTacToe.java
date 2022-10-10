package TicTacToeServer;

public class TicTacToe extends java.lang.Object
{
	static int SPIELER1 = -1;
	static int SPIELER2 = -2;
	private int[][] spielfeld;

	/**
	 * Custom Konstruktor für TicTacToe
	 * @param feldgroesse
	 */
	public TicTacToe(int feldgroesse) {
		spielfeld = new int[feldgroesse][feldgroesse];
		int zaehler = 0;
		for (int i = 0; i < feldgroesse; i++) {
			for (int j = 0; j < feldgroesse; j++) {
				spielfeld[i][j] = zaehler;
				zaehler++;
			}
		}
		
	}

	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j] == SPIELER1) {
					ret = ret + "X";
				} else if (spielfeld[i][j] == SPIELER2) {
					ret = ret + "O";
				} else {
					ret = ret + spielfeld[i][j];
				}
				ret = ret + "\t";
			}
			ret = ret + "\n";
		}
		return ret;
	}

	/**
	 * setzt den Zug für Spieler1
	 * @param zug
	 * @return den rückgabewert ob das setzten funktioniert hat
	 */
	public int setZugSpieler1(int zug) {
		return (setZug(zug, SPIELER1));
	}

	/**
	 * setzt den Zug für Spieler2
	 * @param zug
	 * @return den rückgabewert ob das setzten funktioniert hat
	 */
	public int setZugSpieler2(int zug) {
		return (setZug(zug, SPIELER2));
	}

	/**
	 * Setzt den Zug
	 * @param zug
	 * @param spielernummer
	 * @return
	 */
	private int setZug(int zug, int spielernummer) {
		
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j] == zug) {
					spielfeld[i][j] = spielernummer;
					return 0;
				}
			}
		}
		
		if (zug >= ((spielfeld.length) * (spielfeld.length))) {
			return -1;
		} else {
			return -2;
		}
	}

	/**
	 * gibt zurück wo welcher Spieler was platziert hat
	 * @param zeile
	 * @param spalte
	 * @return spieler1, spieler2 oder 0
	 */
	public int getSpielfeld(int zeile, int spalte) {
		if (zeile > spielfeld.length || spalte > spielfeld.length) {
			return -3;
		} else if (spielfeld[zeile - 1][spalte - 1] == SPIELER1) {
			return SPIELER1;
		} else if (spielfeld[zeile - 1][spalte - 1] == SPIELER2) {
			return SPIELER2;
		} else {
			return 0;
		}
	}

	public int getFeldgroesse() {
		int ret = spielfeld.length;
		return ret;
	}

/**
 * Methode um zu überprüfen wer gewonnen hat
 * @return den gewinner
 */
	public int getGewonnen() {
		/**
		 * Dies funktioniert, da nur Felder, die von Spielern belegt wurden einen gleichen Integer haben können
		 */
		for(int i = 0; i < this.getFeldgroesse(); i++) {
			for(int j = 0; j < this.getFeldgroesse(); j++) {
				 //Horizontal
				if(i < this.getFeldgroesse() -2 && j < this.getFeldgroesse() -2 && this.spielfeld[i][j] == this.spielfeld[i+1][j] &&this.spielfeld[i][j] == this.spielfeld[i+2][j])
					return this.spielfeld[i][j];
				
				//Vertikal
				if(j < this.getFeldgroesse() -2 && this.spielfeld[i][j] == this.spielfeld[i][j+1] &&this.spielfeld[i][j] == this.spielfeld[i][j+2])
					return this.spielfeld[i][j];
				
				//Diagonal
				if(j < this.getFeldgroesse() -2 && i < this.getFeldgroesse() -2 && this.spielfeld[i][j] == this.spielfeld[i+1][j+1] &&this.spielfeld[i][j] == this.spielfeld[i+2][j+2])
					return this.spielfeld[i][j];
			//Horizontal
				if(i < this.getFeldgroesse()-2 && this.spielfeld[i][j] == this.SPIELER1 && this.spielfeld[i+1][j] == this.SPIELER1 && this.spielfeld[i+2][j] == this.SPIELER1)
					return this.SPIELER1;

				//Vertikal
				if(j < this.getFeldgroesse()-2 && this.spielfeld[i][j] == this.SPIELER1 && this.spielfeld[i][j+1] == this.SPIELER1 && this.spielfeld[i][j+2] == this.SPIELER1)
					return this.SPIELER1;

				//Diagonal
				if(i < this.getFeldgroesse()-2 && j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] == this.SPIELER1 && this.spielfeld[i+1][j+1] == this.SPIELER1 && this.spielfeld[i+2][j+2] == this.SPIELER1)
					return this.SPIELER1;

				//Horizontal
				if(i < this.getFeldgroesse()-2 && this.spielfeld[i][j] == this.SPIELER2 && this.spielfeld[i+1][1] == this.SPIELER2 && this.spielfeld[i+2][j] == this.SPIELER2)
					return this.SPIELER2;

				//Vertikal
				if(j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] == this.SPIELER2 && this.spielfeld[i][j+1] == this.SPIELER2 && this.spielfeld[i][j+2] == this.SPIELER2)
					return this.SPIELER2;

				//Diagonal
				if(i < this.getFeldgroesse()-2 && j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] == this.SPIELER2 && this.spielfeld[i+1][j+1] == this.SPIELER2 && this.spielfeld[i+2][j+2] == this.SPIELER2)
					return this.SPIELER2;
			}
		}
		return 0;
	}
	
	/**
	 * gibt zurück ob ein Spieler gewinnen kann
	 * @return true oder false ob einer gewinnen kann
	 */
	public boolean getEinerKannGewinnen() {
		for(int i = 0; i < this.getFeldgroesse(); i++) {
			for(int j = 0; j < this.getFeldgroesse(); j++) {
				//Horizontal
				if(i < this.getFeldgroesse()-2 && this.spielfeld[i][j] > 0 || this.spielfeld[i+1][j] > 0 || this.spielfeld[i+2][j] > 0)
					return true;
				
				//Vertikal
				if(j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] > 0 || this.spielfeld[i][j+1] > 0 || this.spielfeld[i][j+2] > 0)
					return true;
				
				//Diagonal
				if(i < this.getFeldgroesse()-2 && j < this.getFeldgroesse()-2 || this.spielfeld[i][j] > 0 || this.spielfeld[i+1][j+1] > 0 || this.spielfeld[i+2][j+2] > 0)
					return true;
			}
		}
		return false;
	}

}
