
public class Quersummenquersumme
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("Quersumme");
		System.out.println("=========");
		//eingabe der Zahlen
		int zahl = TestScanner.readInt("Geben sie die Zahl ein: ");
		int [] a = {0,0,0,0};
		//Die zahlen werden getrennt
			while (zahl > 10000) {
				zahl-=10000;
				a[0]++;
			}
			while (zahl > 1000) {
				a[1]++;
				zahl-=1000;
			}	
			while (zahl > 100) {
				a[2]++;
				zahl-=100;
			}
			while (zahl > 10) {
				a[3]++;
				zahl-=10;
			}
			//die Zahlen werden zusammengerechnet und Ausgegeben
			System.out.print(a[0] + " + " + a[1] + " + " + a[2] + " + " + a[3] + " + " + zahl);
			int loesung = a[0] + a[1] + a[2] + a[3] + zahl;
			System.out.print(" = " + loesung);
			int b = 0;
			//die Zahlen der Quersumme werden getrennt, gerechnet und ausgegeben
				while (loesung > 10) {
					b++;
					loesung-=10;
				}
				System.out.print(" = " + b + " + " + loesung);
				loesung = b + loesung;
				System.out.print(" = " + loesung);
	}

}
