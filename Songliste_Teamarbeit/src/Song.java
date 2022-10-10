
public class Song implements Comparable<Song>
{
	private String titel = "";
	private String interpret = "";
	private String album = "";
	private int erscheinungsjahr = 0;

	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * @param titel
	 *          the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * @return the interpret
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * @param interpret
	 *          the interpret to set
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *          the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return the erscheinungsjahr
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}

	/**
	 * @param erscheinungsjahr
	 *          the erscheinungsjahr to set
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		if (erscheinungsjahr > 0) {
			this.erscheinungsjahr = erscheinungsjahr;
		}
	}

	/*
	 * Vergleicht 2 songs.
	 * 
	 * @param s - der zu vergleichende song
	 * 
	 * @return true oder false, ob sie gleich sind oder nicht
	 */
	public boolean equals(Song s) {
		boolean ret = false;
		int n = 0;

		if (this.titel.equals(titel)) {
			n++;
		}
		if (this.interpret.equals(interpret)) {
			n++;
		}
		if (this.album.equals(album)) {
			n++;
		}
		if (this.erscheinungsjahr == s.erscheinungsjahr) {
			n++;
		}

		if (n == 4) {
			ret = true;
		}

		return ret;
	}

	/*
	 * vergleicht 2 Songs. Wenn der erste song größer ist als der zweite wird ein
	 * positiver wert zurückgegeben, ansonsten wird ein negativer zurückgegeben.
	 * 
	 * @param s - der zu vergleichende Song
	 * 
	 * @return positiver oder negativer wert, welcher Song größer ist
	 */
	public int compareTo(Song s) {
		int ret = 0;

		String s1 = s.interpret + s.album + s.titel;
		String s2 = interpret + album + titel;

		ret = s2.compareTo(s1);

		if (ret > 0) {
			ret = 1;

		} else if (ret < 0) {
			ret = -1;
		}

		return ret;
	}

	/*
	 * Klont einen Song.
	 * 
	 * @return geklonter Song
	 */
	public Song clone() {
		Song ret = new Song();

		ret.interpret = this.interpret;
		ret.titel = this.titel;
		ret.album = this.album;
		ret.erscheinungsjahr = this.erscheinungsjahr;

		return ret;
	}

	/*
	 * gibt einen Song als String zurück.
	 * 
	 * @return Song als String
	 */
	public String toString() {
		String ret = titel + ";" + album + ";" + interpret + ";" + erscheinungsjahr;

		return ret;
	}

	/*
	 * Setzt einen Song
	 * 
	 * @param song - String mit album name usw, getrennt mit ";"
	 */
	public void setSong(String tags) {

		int a = tags.indexOf(';');
		titel = tags.substring(0, a);
		album = tags.substring(a + 1, tags.indexOf(';', a + 1));
		a = tags.indexOf(';', a + 1);
		interpret = tags.substring(a + 1, tags.indexOf(';', a + 1));
		a = tags.indexOf(';', a + 1);
		erscheinungsjahr = Integer.valueOf(tags.substring(a + 1));
	}

}
