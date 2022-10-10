
public class KleinstesDouble
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Auhor Felix
		double i = 1;
		double ergebnis = 0;
		//solange i größer als 0 ist, wird ergebnis gleich 0 und dann ausgegeben
		while (i>0) {
			i = i/2;
			if (i>0) {
				ergebnis = i;
			}
		}
		System.out.println(ergebnis);
	}
}
