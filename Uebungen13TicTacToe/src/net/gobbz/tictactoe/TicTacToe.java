package net.gobbz.tictactoe;

public class TicTacToe extends java.lang.Object
{
	static int spieler1 = -1;
	static int spieler2 = -2;
	private int[][] spielfeld;

	public TicTacToe(int feldgroesse) {
		System.out.println("================================");
		System.out.println("Herzlich willkommen zu TicTacToe");
		System.out.println("================================");
		spielfeld = new int[feldgroesse][feldgroesse];
		int zaehler = 0;
		for (int i = 0; i < feldgroesse; i++) {
			for (int j = 0; j < feldgroesse; j++) {
				spielfeld[i][j] = zaehler;
				zaehler++;
			}
		}
		char nochmal = 'j';
		while (nochmal == 'j') {
			System.out.println(toString());
			while (setZugSpieler1(TestScannerErweitert.readInt("Spieler 1, ihr Zug: ")) != 0) {
				System.out.println("Zug bereits gesetzt oder auserhalb des Spielfeldes!");
			}
			if(getEinerKannGewinnen()==false) {
				System.out.println("Keiner kann mehr gewinnen, also wird das Spiel abgebrochen!");
				break;
			}
			if (getGewonnen() == -1) {
				System.out.println("Spieler 1 hat gewonnen, Herzlichen Glückwunsch!");
				nochmal = TestScannerErweitert.readChar("Nochmal spielen? (j/n) ");
				if (nochmal == 'n')
					break;
				else if (nochmal == 'j') {
					zaehler = 0;
					for (int i = 0; i < feldgroesse; i++) {
						for (int j = 0; j < feldgroesse; j++) {
							spielfeld[i][j] = zaehler;
							zaehler++;
						}
					}
				}
			}
			System.out.println(toString());
			while (setZugSpieler2(TestScannerErweitert.readInt("Spieler 2, ihr Zug: ")) != 0) {
				System.out.println("Zug bereits gesetzt oder außerhalb des Spielfeldes!");
			}
			if(getEinerKannGewinnen()==false) {
				System.out.println("Keiner kann mehr gewinnen, also wird das Spiel abgebrochen!");
				break;
			}
			if (getGewonnen() == -2) {
				System.out.println("Spieler 2 hat gewonnen, Herzlichen Glückwunsch!");
				nochmal = TestScannerErweitert.readChar("Nochmal spielen? (j/n) ");
				if (nochmal == 'n')
					break;
				else if (nochmal == 'j') {
					zaehler = 0;
					for (int i = 0; i < feldgroesse; i++) {
						for (int j = 0; j < feldgroesse; j++) {
							spielfeld[i][j] = zaehler;
							zaehler++;
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j] == spieler1) {
					ret = ret + "X";
				} else if (spielfeld[i][j] == spieler2) {
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

	public int setZugSpieler1(int zug) {
		return (setZug(zug, spieler1));
	}

	public int setZugSpieler2(int zug) {
		return (setZug(zug, spieler2));
	}

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

	public int getSpielfeld(int zeile, int spalte) {
		if (zeile > spielfeld.length || spalte > spielfeld.length) {
			return -3;
		} else if (spielfeld[zeile - 1][spalte - 1] == spieler1) {
			return spieler1;
		} else if (spielfeld[zeile - 1][spalte - 1] == spieler2) {
			return spieler2;
		} else {
			return 0;
		}
	}

	public int getFeldgroesse() {
		int ret = spielfeld.length;
		return ret;
	}

	/**
	 * Dies ist die unpragmatischste Methode, welche ich jemals geschrieben habe.
	 * zuerst hatte ich sie anders gemacht aber sie hat nach 1h noch nicht
	 * funktioniert, darauf war ich so genervt, dass ich es einfach so geloeßt habe
	 * Die Methode ueberprueft ob einer der beiden Spieler gewonnen hat, falls dies
	 * zutrifft wird die Spielernummer zurueckgegeben, sonst 0
	 * 
	 * @return die Spielernummer, falls jemand gewonnen hat, sonst 0
	 */
	public int getGewonnen() {
		int ret = 0;
		// spieler1
		if (spielfeld[0][0] == spieler1 && spielfeld[0][1] == spieler1 && spielfeld[0][2] == spieler1)
			return spieler1;
		if (spielfeld[1][0] == spieler1 && spielfeld[1][1] == spieler1 && spielfeld[1][2] == spieler1)
			return spieler1;
		if (spielfeld[2][0] == spieler1 && spielfeld[2][1] == spieler1 && spielfeld[2][2] == spieler1)
			return spieler1;
		if (spielfeld[0][0] == spieler1 && spielfeld[1][0] == spieler1 && spielfeld[2][0] == spieler1)
			return spieler1;
		if (spielfeld[0][1] == spieler1 && spielfeld[1][1] == spieler1 && spielfeld[2][1] == spieler1)
			return spieler1;
		if (spielfeld[0][2] == spieler1 && spielfeld[1][2] == spieler1 && spielfeld[2][2] == spieler1)
			return spieler1;
		if (spielfeld[0][0] == spieler1 && spielfeld[1][1] == spieler1 && spielfeld[2][2] == spieler1)
			return spieler1;
		if (spielfeld[2][2] == spieler1 && spielfeld[1][1] == spieler1 && spielfeld[2][0] == spieler1)
			return spieler1;
		// spieler2
		if (spielfeld[0][0] == spieler2 && spielfeld[0][1] == spieler2 && spielfeld[0][2] == spieler2)
			return spieler2;
		if (spielfeld[1][0] == spieler2 && spielfeld[1][1] == spieler2 && spielfeld[1][2] == spieler2)
			return spieler2;
		if (spielfeld[2][0] == spieler2 && spielfeld[2][1] == spieler2 && spielfeld[2][2] == spieler2)
			return spieler2;
		if (spielfeld[0][0] == spieler2 && spielfeld[1][0] == spieler2 && spielfeld[2][0] == spieler2)
			return spieler2;
		if (spielfeld[0][1] == spieler2 && spielfeld[1][1] == spieler2 && spielfeld[2][1] == spieler2)
			return spieler2;
		if (spielfeld[0][2] == spieler2 && spielfeld[1][2] == spieler2 && spielfeld[2][2] == spieler2)
			return spieler2;
		if (spielfeld[0][0] == spieler2 && spielfeld[1][1] == spieler2 && spielfeld[2][2] == spieler2)
			return spieler2;
		if (spielfeld[2][2] == spieler2 && spielfeld[1][1] == spieler2 && spielfeld[2][0] == spieler2)
			return spieler2;

		return ret;
	}

	public boolean getEinerKannGewinnen() {
		for(int i = 0; i < this.getFeldgroesse(); i++) {
			for(int j = 0; j < this.getFeldgroesse(); j++) {
				//Horizontal
				if(i < this.getFeldgroesse()-2&&this.spielfeld[i][j] > 0 && this.spielfeld[i+1][j] > 0 && this.spielfeld[i+2][j] > 0)
					return true;
				
				//Vertikal
				if(j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] > 0 && this.spielfeld[i][j+1] > 0 && this.spielfeld[i][j+2] > 0)
					return true;
				
				//Diagonal
				if(i < this.getFeldgroesse()-2 && j < this.getFeldgroesse()-2 &&this.spielfeld[i][j] > 0 && this.spielfeld[i+1][j+1] > 0 && this.spielfeld[i+2][j+2] > 0)
					return true;
			}
		}
		return false;
	}

}
