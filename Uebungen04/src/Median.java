
public class Median
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("Median");
		System.out.println("======");
		//Eingabe der Variablen
		int a = TestScanner.readInt("1. Zahl: ");
		int b = TestScanner.readInt("2. Zahl: ");
		int c = TestScanner.readInt("3. Zahl: ");
		//herausfinden des Medians
		if (a>b) {
			if (a>c) {
				if (c>b) {
					System.out.println(b+ " ist der Median.");
				}
				else 
					System.out.println(c+" ist der Median.");
			}
			else 
				System.out.println(a+" ist der Median.");
		}
		else
			if (c>b) {
				System.out.println(b+" ist der Median.");
			}
			else 
				if (c>a) 
					System.out.println(a+" ist der Median.");
				else 
					System.out.println(c+ "ist der Median.");
	}
}
