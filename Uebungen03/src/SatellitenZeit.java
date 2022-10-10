
public class SatellitenZeit
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("SatellitenZeit");
		System.out.println("==============");
		//Variablen
		int s = TestScanner.readInt("Geben Sie die Sekunden ein: ");
		int m = 0;
		int h = 0;
		int d = 0;
		int i = 0;
		if (s>=60) {
			//Rechnungen
			while (i<100000) {
				s-=60;
				m++;
				if(s<60) {
					i+=100000;
				}
			}
		}
		if (m>=60) {
			i = 0;
			while (i<100000) {
				m-=60;
				h++;
				if(m<60) {
					i+=100000;
				}
			}
		}
		if (h>=24) {
			i = 0;
			while (i<100000) {
				h-=24;
				d++;
				if (h<24) {
					i+=100000;
				}
			}
		}
		//Ausgabe
		System.out.println("Die umgerechnete Zeit ist:");
		System.out.println("d " + d  + " h " + h + " m " + m + " s " + s);
	}
}