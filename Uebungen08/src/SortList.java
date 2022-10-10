import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SortList {

	public static void main(String[] args) {
		//@Author Felix
		String q = "C:\\Eclipse\\Info\\Work\\Uebungen08\\src\\tracklist.csv";
		String z = "C:\\Eclipse\\Info\\Work\\Uebungen08\\src\\sortlist.csv";
		
		Song[] list = new Song [zZeile(q) - 1];
		Song zs = new Song();
		for (int i = 0; i < list.length; i++) {
			list[i] = new Song();
		}
		
		list = leseDatei (q, list);
		
		for (int i = 1; i < list.length; i++) {
			int j = i;
			
			while (j != 0 && list[j].compareTo (list [j - 1]) == 1) {
				
				zs = list[j].clone();
				list [j] = list [j - 1].clone();
				list [j - 1] = zs.clone();
				j--;
			}
		}
		
		schreibeDatei(list, z);
	}

	/*
	 * Aus der Datei "Quelle" wird die Anzahl der beschriebenen Zeieln gezählt.
	 * @param q - Die Quelle
	 * @return Anzahl Zeilen
	 */
	public static int zZeile(String q) {
		int ret = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(q));
			
			while (true) {
				if (reader.readLine() == null) {
					break;
				}

				else {
					ret++;
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
			
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		return ret;
	}

	/*
	 * Es wird alles aus "Quelle" in das Array als Songs geschrieben.
	 * @param q - Die Quelle
	 * @param Song (Array)
	 * @return Song (Array) mit Daten
	 */
	public static Song[] leseDatei(String q, Song[] ret) {
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(q));
			reader.readLine();
			
			for (int i = 0; i < ret.length; i++) {
				ret[i].setSong(reader.readLine());
			}
			
			reader.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
			
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		return ret;
	}

	/*
	 * Das übergebene Array wird in die "ziel" Datei geschhrieben
	 * @param slist - Array 
	 * @param z - Zieldatei
	 */
	public static void schreibeDatei(Song[] slist, String z) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(z));
			writer.write("Titel;Album;Interpret;Jahr\n");
			
			// ACHTUNG: Am Ende jeder Zeile muss eine Zeilenschaltung \n eingefuegt werden
			for (int i = 0; i < slist.length; i++) {
				writer.write(slist[i] + "\n");
			}

			writer.close();
			
		} catch (IOException e) {
			System.out.println("Datei nicht angelegt");
		}
	}
}