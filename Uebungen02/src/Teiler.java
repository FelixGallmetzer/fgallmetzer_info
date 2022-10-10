
public class Teiler
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		int z = 7;
		int teiler = 1;
		int ergebnis= 0;
		System.out.print("Die Teiler von " + z + " sind:  " );
		// teiler wird minus 1 gemacht. falls z teilbar durch den teiler ist, wird es ausgegeben
		while(teiler <= z && teiler > 0) {
			if (z%teiler == 0) {
				ergebnis = z/teiler;
				teiler++;
				System.out.print(ergebnis + "  ");	
			}
			else {
				teiler++;
			}
		}
	}
}
