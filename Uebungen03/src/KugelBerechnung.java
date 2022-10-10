
public class KugelBerechnung
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("KugelBerechnung");
		System.out.println("===============");
		//es wird die Methode "readDouble" in der java Datei "TestScanner" aufgerufen
		Double d=TestScanner.readDouble("Geben Sie den Radius der Kugel ein: ");
		//hier werden der Umfang, Volumen und Oberfläche berechnet und ausgegeben
		double umfang=2d*Math.PI*d;
		System.out.println("Der Umfang der Kugel beträgt: " + umfang);
		double ofläche=4d*Math.PI*Math.pow(d, 2);
		System.out.println("Die Oberfläche der Kugel beträgt: " + ofläche);
		double volumen=4d/3*Math.PI*Math.pow(d, 3);
		System.out.println("Das Volumen der Kugel beträgt: " + volumen);

	}

}
