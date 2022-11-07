package RatenRechner;


public class RatenRechner {
	private static boolean nachschuessig = false;
	private static double laufzeitInJahren = 0;
	private static int ratenProJahr = 0;
	private static double jahreszinssatz = 0;
	private static double barwert = 0;
	private static double rate = 0;
	
	/**
	 * setzt nachschüssig
	 * @param n
	 */
	public void setNachschuessig(boolean n) {
		nachschuessig = n;
	}

	/**
	 * setzt den Barwert
	 * @param sbarwert
	 * @throws RatenRechnerException
	 */
	public void setBarwert(String sbarwert) throws RatenRechnerException {
		try {
			double ueberpruefung = Double.parseDouble(sbarwert);
			if (!(ueberpruefung <= 0)) {
				barwert = ueberpruefung;
				barwert = Math.floor(barwert);
			} else {
				throw new RatenRechnerException("");
			}
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * Berechnet den Barwert
	 * @return
	 * @throws RatenRechnerException
	 */
	public String getBarwert() throws RatenRechnerException {
		if (laufzeitInJahren == 0 || ratenProJahr == 0 || jahreszinssatz == 0 || rate == 0) {
			throw new RatenRechnerException("Jahreszinssatz, Laufzeit, Raten pro Jahr oder Rate nicht gesetzt");
		} else {
			final double n = laufzeitInJahren * ratenProJahr;
			final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
			if (nachschuessig)
				barwert = rate * (Math.pow(q, n) - 1.) / (Math.pow(q, n) * (q - 1.));
			else
				barwert = rate * (Math.pow(q, n)- 1.) / (Math.pow(q, n - 1.) * (q - 1.));
			barwert = Math.floor(barwert);
			return String.valueOf(barwert);
		}
	}

	/**
	 * setzt die Raten Pro Jahr
	 * @param sraten
	 * @throws RatenRechnerException
	 */
	public void setRatenProJahr(String sraten) throws RatenRechnerException{
		if (Integer.parseInt(sraten) == 1 || Integer.parseInt(sraten) == 4 || Integer.parseInt(sraten) == 6 || Integer.parseInt(sraten) == 12) {
			ratenProJahr = Integer.parseInt(sraten);
		}
	}
	
	/**
	 * setzt den Jahres zinssatz
	 * @param szins
	 * @throws RatenRechnerException
	 */
	public void setJahreszinssatz(String szins) throws RatenRechnerException {
		try {
			jahreszinssatz = Double.parseDouble(szins);
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("");
		}
	}
	
	/**
	 * setzt die Laufzeit
	 * @param szeit
	 * @throws RatenRechnerException
	 */
	public void setLaufZeitInJahren(String szeit) throws RatenRechnerException {
		try {
			double ueberpruefung = Double.parseDouble(szeit);
			if (!(ueberpruefung <= 0)) {
				laufzeitInJahren = Double.parseDouble(szeit);
				laufzeitInJahren = Math.floor(laufzeitInJahren * 100) / 100;
			} else {
				throw new RatenRechnerException("");
			}
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("kein gültiger Gleitkommawert");
		}
	}
	
	/**
	 * berechnet die Laufzeit
	 * @return the laufzeitInJahren
	 */
	public String getLaufzeitInJahren() throws RatenRechnerException {
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;

		if (nachschuessig) {
			laufzeitInJahren = (-Math.log((rate - barwert * (q - 1.)) / rate) / Math.log(q)) / ratenProJahr;
		} else {
			laufzeitInJahren = (1. - Math.log((q * rate - barwert * (q - 1.)) / rate) / Math.log(q)) / ratenProJahr;
		}
		String laufzeitInJahrenstr = Double.toString(Math.round(laufzeitInJahren * 100.0) / 100.0);
		return laufzeitInJahrenstr;
	}

	/**
	 * berechnet die Rate
	 * @return
	 * @throws RatenRechnerException
	 */
	public String getRate() throws RatenRechnerException {
		final double n = laufzeitInJahren * ratenProJahr;
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		if (nachschuessig)
			rate = barwert * (Math.pow(q, n) * (q - 1.)) / (Math.pow(q, n) - 1.);
		else
			rate = barwert * (Math.pow(q, n - 1.) * (q - 1.)) / (Math.pow(q, n) - 1.);
		rate = Math.floor(rate * 100) / 100;
		return String.valueOf(rate);
	}


	/**
	 * gibt den Tilgungsplan zurück
	 * @return
	 * @throws RatenRechnerException
	 */
	public static String getTilgungsplan() throws RatenRechnerException {
		String htmlhead = null;
		String htmllines = null;
		String htmlend = null;
		String htmlcode = null;
		String nachschuessigletter = null;
		if (nachschuessig) {
			nachschuessigletter = "Nachschuessig";
		} else {
			nachschuessigletter = "Vorschuessig";
		}
			
		final double q = 1. + (jahreszinssatz / ratenProJahr) / 100.;
		double rkapital = barwert;
		htmlhead =	"<h1>Tilgungsplan</h1>"
				+				"<table border=\"1\">"
				+					"<tr>"
				+						"<th>Zahlungsart:</th>"
				+						"<td>"+nachschuessigletter+"</td>"
				+					"</tr>"
				+					"<tr>"
				+						"<th>Barwert:</th>"
				+						"<td>"+barwert+"</td>"
				+					"</tr>"
				+					"<tr>"
				+						"<th>Jahreszinssatz:</th>"
				+						"<td>"+jahreszinssatz+" %</td>"
				+					"</tr>"
				+					"<tr>"
				+						"<th>Laufzeit in Jahren:</th>"
				+						"<td>"+laufzeitInJahren+"</td>"
				+					"</tr>"
				+					"<tr>"
				+						"<th>R�ckzahlungsart:</th>"
				+						"<td>"+ratenProJahr+" Raten im Jahr</th>"
				+					"</tr>"
				+					"<tr>"
				+						"<th>Rate:</th>"
				+						"<td>"+rate+"</td>"
				+					"</tr>"
				+				"</table>"
				+				"<table border=\"1\">"
				+ 					"<tr>"
				+ 						"<th>Periode</th>"
				+ 						"<th>Rate</th>"
				+ 						"<th>Restkapital</th>"
				+						"<th>Zinsen</th>"
				+ 					"</tr>";
		htmlcode = htmlhead;
		for (int i = 1; i <= (int) (laufzeitInJahren * ratenProJahr); ++i) {
			final double zins;
			if (nachschuessig) {
				zins = Math.round(((rkapital * (q - 1.))*100.0) / 100.0);
				rkapital=Math.round(((rkapital * q - rate)*100.0)/100.0);
			} else {
				zins = (rkapital - rate) * (q - 1.);
				rkapital = Math.round(((rkapital - rate + zins)*100.0)/100.0);
			}
			htmllines =				"<tr>"
					+					"<td>"+i+"</td>"
					+					"<td>"+Math.round((rate * 100.0) / 100.0)+"</td>"
					+					"<td>"+rkapital+"</td>"
					+					"<td>"+zins+"</td>"
					+				"</tr>";
			htmlcode = htmlcode + htmllines;
		}
		htmlend = "</table>";
		htmlcode = htmlcode + htmlend;
		return htmlcode;
	}
	
	/**
	 * setzt die Rate
	 * @param srate
	 * @throws RatenRechnerException
	 */
	public void setRate(String srate) throws RatenRechnerException {
		try {
			rate = Double.parseDouble(srate);
			rate = Math.floor(rate * 100) / 100;
		} catch (NumberFormatException e) {
			throw new RatenRechnerException("");
		}
	}
}
