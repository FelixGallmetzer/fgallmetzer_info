
public class PerfekteZahlen
{

	public static void main(String[] args) {
		//@Author Felix
		//Definierung der Variablen
		int z = 6;
		int teiler = 2;
		int ergebnis= 0;
		int e2 = 0;
		int [] a = {0,0,0,0,0};
		int i = 0;
		//Die Teiler werden bestimmt und zusammengerechnet
		while (i<=4) {
			while(teiler <= z && teiler > 0) {
				if (z%teiler == 0) {
					ergebnis = z/teiler;
					teiler++;
					e2 = e2 + ergebnis;
				}
				else {
					teiler++;
				}
			}
			//Vergleich zwischen den zusammengerechneten Teilern und der zahl
			if (e2 == z) {
				a[i] = e2;
				i++;
				z++;
				teiler = 2;
				e2 = 0;
			}
			else {
				z++;
				teiler = 2;
				e2 = 0;
			}
		}
		//Ausgabe
		System.out.println("Die ersten 5 perfekten Zahlen sind: " + a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
	}
}
