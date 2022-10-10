import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SongListe
{

	private Song[] songs;
	private int nummerAktueller = -1;
	private int anzahl = 0;
	private String pfad;
	private static final int DEFAULT_MAXANZAHL = 1000;

	/*
	 * Konstruktor, der ein privates Array initialisiert in welchem maxAnzahl Songs
	 * aufgenommen werden können. Ist maxAnzahl <= 0, so wird über die interne
	 * songs-Variable ein Array angelegt das DEFAULT_MAXANZAHL Songs aufnehmen kann.
	 * Weiters wird anzahl auf 0 gesetzt weil noch keine Songs in der Liste
	 * vorhanden sind und nummerAktueller auf -1, weil noch kein Song angesprungen
	 * wurde
	 * 
	 * @param maxAnzahl - die maximale Anzahl von Songs die aufgenommen werden
	 * können
	 */
	public SongListe(int maxAnzahl) {
		if (maxAnzahl <= 0) {
			songs = new Song[DEFAULT_MAXANZAHL];
		} else {
			songs = new Song[maxAnzahl];
		}

		this.nummerAktueller = -1;
		this.anzahl = 0;
	}

	/*
	 * Liefert die Maximale Anzahl von Songs zurück, die im Array abgespeichert
	 * werden können
	 * 
	 * @return die Anzahl der im Array maximal eintragbaren Songs
	 */
	public int getMaxAnzahl() {
		int ret = songs.length;
		return ret;
	}

	/*
	 * Liefert den aktuellen Song zurück auf den der Songzeiger nummerAktueller
	 * zeigt
	 * 
	 * @return den aktuellen Song oder null, falls kein Song in der Songliste
	 * enthalten ist
	 */
	public Song getAktueller() {
		Song ret = songs[nummerAktueller];
		return ret;
	}

	/*
	 * Gibt die Anzahl der Songs zurück, die momentan im Array vorhanden sind
	 * 
	 * @return die Anzahl der Songs die im Array momentan eingetragen sind 0 falls
	 * das Array zwar angelegt wurde aber noch keine Elemente enthalten sind
	 */
	public int getAnzahl() {
		int ret = anzahl;
		return ret;
	}

	/*
	 * Liefert den ersten Song in der Songliste zurück und setzt den Songzeiger auf
	 * diesen Song. Ist die Liste leer, wird null zurück geliefert
	 * 
	 * @return den ersten Song in der Liste
	 */
	public Song getErster() {
		Song ret = songs[0];
		nummerAktueller = 0;
		return ret;
	}

	/*
	 * Liefert den letzten Song in der Songliste zurück und setzt den Songzeiger auf
	 * diesen Song. Ist die Liste leer, wird null zurück geliefert
	 * 
	 * @return den letzten Song
	 */
	public Song getLetzter() {
		Song ret = new Song();
		ret = songs[anzahl - 1];
		nummerAktueller = anzahl - 1;
		return ret;
	}

	/*
	 * Liefert den nächsten Song - falls vorhanden - zurück und erhöht den
	 * Songzeiger nummerAktueller um Eins. Gibt es keinen nächsten Song, wird null
	 * zurück geliefert und der Songzeiger nicht erhöht
	 * 
	 * @return liefert den nächsten Song zurück oder null, falls dieser Song nicht
	 * vorhanden ist
	 */
	public Song getNaechster() {
		Song ret = songs[nummerAktueller + 1];
		if (nummerAktueller < anzahl && songs[nummerAktueller + 1] != null) {
			nummerAktueller++;
		} else {
			ret = this.getLetzter();
		}
		return ret;
	}

	/*
	 * Liefert den vorigen Song - falls vorhanden - zurück und vermindert den
	 * Songzeiger um Eins. Gibt es keinen vorigen Song wird null zurück geliefert
	 * und der Songzeiger nicht vermidert
	 * 
	 * @return den vorigen Song
	 */
	public Song getVoriger() {
		Song ret = new Song();
		if (nummerAktueller > 0 && nummerAktueller != -1 && songs[nummerAktueller - 1] != null) {
			ret = songs[nummerAktueller - 1];
			nummerAktueller--;
		} else {
			ret = songs[0];
		}
		return ret;
	}

	public int getNummerAktuell() {
		int ret = nummerAktueller;
		return ret;
	}

	/*
	 * Setzt den Dateipfad auf jene Datei aus welcher die Songs gelesen bzw. in
	 * welche die Songs geschrieben werden soll
	 * 
	 * @param pfad
	 */
	public void setPfad(java.lang.String pfad) {
		this.pfad = pfad;
	}

	/*
	 * Liest den Dateipfad aus
	 * 
	 * @return dateipfad
	 */
	public java.lang.String getPfad() {
		java.lang.String ret = pfad;
		return ret;
	}

	/*
	 * Trägt einen neuen Song am Ende der Songliste ein. Die Anzahl der Songs wird
	 * um Eins erhöht und die nummerAktueller wird auf diesen Song gesetzt. Der Song
	 * wird nicht eingetragen, wenn im Array kein Platz mehr ist
	 * 
	 * @param s - der einzutragende Song
	 * 
	 * @return 0 falls das Eintragen erfolgreich war -1 falls kein einzutragender
	 * Song übergeben wurde -2 falls die Songliste keinen Platz für einen weiteren
	 * Song hat
	 */
	public int anfuegenNeuen(Song s) {
		int ret = 0;
		if (anzahl + 1 <= getMaxAnzahl() && s != null) {
			ret = 0;
			anzahl++;
			nummerAktueller = anzahl - 1;
		} else if (s == null) {
			ret = -1;
		} else if (anzahl + 1 == getMaxAnzahl()) {
			ret = -2;
		}
		return ret;
	}

	/*
	 * Ändert den aktuellen Song auf den übergebenen Song ab und sortiert ihn nicht
	 * ein
	 * 
	 * @param s - der Song der die zu ändernden Werte enthält
	 * 
	 * @return 0 falls die Änderung erfolgreich durchgeführt werden konnte -1 falls
	 * kein zu ändernder Song übergeben wurde -2 falls der aktuelle Song nicht
	 * bekannt ist
	 */
	public int aendernAktuellen(Song s) {
		int ret = 0;
		if (s != null) {
			songs[nummerAktueller] = s;
		} else {
			ret = -1;
		}

		return ret;
	}

	/*
	 * Löscht den aktuellen Song aus der Liste. Dies kann nur passieren, wenn die
	 * Nummer des aktuellen Songs gesetzt ist. Da im Array eine Lücke entsteht,
	 * müssen alle nachfolgenden Songs um eine Stelle nach vorne geschoben werden.
	 * Der aktuelle Song wird jener Song der dem zu löschenden Song folgt. Ist der
	 * zu löschende Song der letzte Song in der Liste, so wird der aktuelle Song
	 * jener Song der vor dem zu löschenden Song vorhanden ist. Ist der zu löschende
	 * Song der einzige in der Liste, so wird die nummerAktueller auf -1 gesetzt.
	 * Beim Löschen wird anzahl um Eins verringert
	 * 
	 * @return 0 falls das Löschen erfolgreich durchgeführt werden konnte -1 falls
	 * der aktuelle Song noch nicht gesetzt wurde oder null übergeben wurde
	 */
	public int loeschenAktuellen() {
		int ret = 0;
		int nummer_t = nummerAktueller;

		if (songs[nummer_t] != null) {

			if (nummer_t < anzahl) {

				while (nummer_t < anzahl - 1) {
					songs[nummer_t] = songs[nummer_t + 1];
					nummer_t++;
				}

			} else if (nummer_t == anzahl - 1) {
				songs[nummer_t] = null;
				nummerAktueller--;
			}
			anzahl -= 1;
		} else {
			ret = -1;
		}

		return ret;
	}

	/*
	 * Löscht alle Songs aus der Liste. Setzt die Anzahl auf 0 und die Nummer des
	 * aktuellen Songs auf -1
	 * 
	 * @return 0 falls das Löschen erfolgreich war -1 falls die Liste bereits leer
	 * ist
	 */
	public int loeschenAlle() {
		int ret = 0;

		if (anzahl > 0) {
			for (int i = 0; i < anzahl; i++) {
				songs[(anzahl - 1) - i] = null;
			}
			nummerAktueller = -1;
			anzahl = 0;
		} else {
			ret = -1;
		}

		return ret;
	}

	/*
	 * Aus https://stackoverflow.com/a/18009472 kopiert auf Hinweis von
	 * Raphael/Rafid zählt die Zeilen einer csv Datei
	 * 
	 * @return die Anzahl der Zeilen
	 */
	public static int countLines(String filepath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
		String input;
		int count = 0;
		while ((input = bufferedReader.readLine()) != null) {
			count++;
		}

		// System.out.println("Count : "+count);
		bufferedReader.close();
		return count;
	}

	/*
	 * Lädt die Songs aus der Textdatei die in pfad vorhanden ist. Dabei werden die
	 * bereits in der Songliste gespeicherten Songs gelöscht. Nach dem Einfügen sind
	 * die Songs in sortierter Reihenfolge vorhanden. Als aktueller Song wird der
	 * Erste angesprungen
	 * 
	 * @return 0 falls die Songs erfolgreich ein gefügt werden konnten -1 falls der
	 * Pfad nicht gesetzt ist -2 falls die Datei nicht zu finden ist -3 falls ein
	 * Lesefehler in der Datei vorhanden ist -4 das interner Array kann nicht alle
	 * Songs aufnehmen, weil es zu klein dimensioniert ist
	 */
	public int lesenSongs() {

		int ret = 0;
		try {
			this.anzahl = countLines(pfad);
			nummerAktueller = 0;
			if (pfad != null && !pfad.isEmpty()) {
				BufferedReader reader = new BufferedReader(new FileReader(pfad));

				for (int i = 0; i < this.anzahl; i++) {
					String song = reader.readLine();
					songs[i] = new Song();
					songs[i].setSong(song);
				}

				reader.close();
				Arrays.sort(songs, 0, anzahl);
			} else {
				ret = -1;
			}

		} catch (FileNotFoundException e) {
			ret = -2;

		} catch (IOException e) {
			ret = -3;

		}
		return ret;
	}

	/*
	 * Schreibt die Songs in die Textdatei. Dabei werden die in der Datei
	 * gespeicherten Songs gelöscht
	 * 
	 * @return 0 falls die Songs erfolgreich ein gefügt werden konnten -1 falls der
	 * Pfad nicht gesetzt wurde -2 falls die Datei nicht angelegt werden konnte
	 */
	public int schreibenSongs() {
		int ret = 0;
		try {
			Arrays.sort(songs, 0, anzahl);
			if (pfad != null && !pfad.isEmpty()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(pfad));

				for (int i = 0; i < anzahl; i++) {
					writer.write(songs[i].toString() + "\n");
				}

				writer.close();
			} else {
				ret = -1;
			}
		} catch (IOException e) {
			ret = -2;
			System.out.println("Fehler202");
		}
		return ret;
	}
}