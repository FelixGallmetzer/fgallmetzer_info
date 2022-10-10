
public class PrimzahlTest
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		int x = Integer.parseInt(args[0]);
		int z = 0;
		int i = 0;
		//falls es teilbar ist wird 1++ gemacht somit kann bestimmt werden ob es eine Primzahl ist
		while (z <= x) {
			z++;
			if(x % z == 0) 
				i++;
			//das ergebnis wird ausgegeben
			if(i == 2) {
				System.out.println(x + " ist eine Primzahl");
				z+=x;
			}
			else { 
				System.out.println(x + " ist keine Primzahl");
				z+=x;
			}
		}
		
	}

}
