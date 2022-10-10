
public class Fibonacci
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix 
		System.out.println("Fibonacci-Zahlen");
		System.out.println("================");
		boolean f = true;
		int a = 1;
		int b = 1;
		int i = 0;
		int n = 0;
		int c = 1;
		while (f == true) {
			//einlesen der Variablen mit Fehlermeldung
			n = TestScanner.readInt("Die wievielte Zahl? ");
			if (n<0) {
				System.out.println("Die Zahl muss größer oder gleich Null sein");
			}
			if(n>=0) {
				f = false;
			}
		}
		//wen 0 oder 1 ist dann ist das ergebnis 1
		if (n==0) {
			System.out.println("Die 0. Fibonacci-Zahl lautet 1");
			i += n + 1;
		}
		if (n==1) {
			System.out.println("Die 1. Fibonacci-Zahl lautet 1");
			i += n + 1;
		}
		//fibonacci reihe wird berechnet und dann ausgegeben
		if (i<n) {
			while (i<n - 1) {
				b = a;
				a = c;
				c = a + b;
				i++;
			}
			System.out.println("Die " + n + ". Fibonacci-Zahl lautet " + c);
		}
	}
}
