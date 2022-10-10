
public class SparenInRaten
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sparen In Raten");
		System.out.println("===============");
		//einlesen der Variablen
		Double guthaben=TestScanner.readDouble("Geben Sie ihr Guthaben an Jahresanfang ein: ");
		Double rate=TestScanner.readDouble("Geben Sie die Monatsrate ein: ");
		Double zinsen=TestScanner.readDouble("Geben Sie den Jahreszinssatz ein: ");
		Double ge=0.0;
		Double i = 12.0;
		Double mrate=0.0;
		//Rechnung
		while (i>0) {
			mrate += rate + rate/100d * i/12d *zinsen;
			i--;
		}
		ge = guthaben+(guthaben*zinsen)/100 + mrate;
		System.out.println("Das Guthaben am Ende des Jahres beträgt: " + Math.floor(ge*100)/100);
	}
}
