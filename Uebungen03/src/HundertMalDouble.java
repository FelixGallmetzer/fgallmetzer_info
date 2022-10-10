
public class HundertMalDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ergebnis = 0;
		int i = 0;
		//es wird eine Schleife erzeugt, in der man 100 mal 0.1 addiert
		while (i<100) {
			ergebnis+=0.1;
			i++;
		}
		//es ergibt nicht genau 10, da der Rechner nicht mit allen Dezimalstellen rechnet
		System.out.println(ergebnis);
	}

}
