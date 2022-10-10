
public class FakultaetTabelle
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		//Überschrift
		System.out.println("       n       n!");
		System.out.println("=================");
		int fakultaet = 1;
		int faktor = 1;
		int i = 0;
		while (i<10) {
			i++;
			//die erste Spalte und die Leerzeichen
			zahl(i);
			while(faktor<=i) {
				fakultaet *= faktor;
				faktor++;
			}
			//die Fakultät wird ausgegeben
			fakultaet(fakultaet);
			fakultaet = 1;
			faktor = 1;
		}
	}
	//die Leerzeichen vor der Fakultät
	public static void fakultaet (int zahl) {
		int j = 10;
		int k = 8;
		while (j<=1000000000) {
			if (zahl<j) {
				while (k>0) {
					System.out.print(" ");
					k--;
				}
				System.out.println(zahl);
				j = 1000000000+1;
			}
			j *= 10;
			k--;
		}
	}
	//die Leerzeichen vor i
	public static void zahl (int s) {
		if (s < 10) {
			System.out.print("       "+ s);
		}
		else {
			System.out.print("      "+ s);
		}
	}
}
