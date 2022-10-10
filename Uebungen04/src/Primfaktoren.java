
public class Primfaktoren
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("Primfaktorzerlegung");
		System.out.println("===================");
		boolean f = true;
		int n = 0;
		int ns = 0;
		//Eingabe der Variablen
		while (f == true) {
			n = TestScanner.readInt("Geben sie die Zahl ein: ");
			if (n<2) {
				System.out.println("Die Zahl muss größer als 1 sein");
			}
			if (n>=2) {
				f = false;
			}
			ns = n;
		}
		System.out.println();
		System.out.println("Die Zerlegung lautet: ");
		int teiler = 2;
		//die Teiler werden ermittelt und dann ausgegeben
		while (n>1) {
			if (n%teiler == 0) {
				n = n/teiler;
				System.out.print(teiler);
				if (n>2) {
					System.out.print(" * ");
				}
			}
			//falls es nicht teilbar ist, wird der Teiler erhöht
			else {
				teiler++;
			}
		}
		System.out.println(" = " + ns);
	}
}
