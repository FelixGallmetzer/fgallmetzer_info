
public class Zinseszinsen
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("Zinseszinsen");
		System.out.println("============");
		//hier werden die Werte eingelesen
		Double k0=TestScanner.readDouble("Bitte geben Sie das Anfangskapital ein: ");
		Double p=TestScanner.readDouble("Bitte geben Sie den Zinssatz ein: ");
		int n=TestScanner.readInt("Bitte geben Sie die Jahre ein: ");
		//hier werden die Berechnungen gemacht und das Ergebnis ausgegeben
		int kn= (int) Math.floor((k0*Math.pow(1+p/100, n)));
		System.out.println("Das Endkapital nach " + n + " Jahren beträgt: " + kn );

	}

}
