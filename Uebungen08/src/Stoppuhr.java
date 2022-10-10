import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Stoppuhr
{
	
	private long[] zeitS = new long[1000];
	private long s = 0;
	private int in = 0;
	private String datei = "C:\\";
	
	/*
	 * gibt die Datei zurück
	 * @return die Datei
	 */
	public String getDatei() {
		return datei;
	}
	
	/*
	 * gibt die gespeicherte Zeit zurück
	 * @return letzte gespeicherte Zeit
	 */
	public long getGestoppteZeit() {
		in++;
		return zeitS[in - 1];
	}

	/*
	 * setzt den Dateinamen
	 */
	public void setDateiname(String dateiN) {
		this.datei = dateiN;
	}

	/*
	 * Die Zeit vom Aufruf wird in "start" gespeichert
	 */
	public void starteStoppuhr() {
		s = new java.util.GregorianCalendar().getTimeInMillis();
	}

	/*
	 * berechnet die gespeicherte Zeit und speichert diese
	 */
	public void stoppeStoppuhr() {
		zeitS[in] = new java.util.GregorianCalendar().getTimeInMillis() - s;
	}

	/*
	 * Alle objekte von der gestoppten Zeit wird in die csv datei geschrieben 
	 * @return 0; bei misserfolg gibt es -1 zurück
	 */
	public int schreibeZeiten() {
		int ret = 0;
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
			
			// ACHTUNG: Am Ende jeder Zeile muss eine Zeilenschaltung \n eingefuegt werden
			for (int i = 0; i < in; i++) {
				writer.write(zeitS[i] + "\n");
			}
			
			writer.close();
			
		} catch (IOException e) {
			ret = -1;
		}
		return ret;
	}
}
