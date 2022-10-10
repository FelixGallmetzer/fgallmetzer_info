
public class GgTEuklid
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("GgT von Euklid");
		System.out.println("==============");
		//EIngabe der Zahlen
		int z1 = TestScanner.readInt("erste Zahl: ");
		int z2 = TestScanner.readInt("zweite Zahl: ");
		int z3 = 0;
		//Berechnung des GgT
		if(z2<z1) {
			while (z1%z2 != 0) {
				z3 = z1%z2;
				z1 = z2;
				z2 = z3;
			}
			System.out.println("der größte gemeinsame Teiler lautet: " + z3);
		}
	}
}
