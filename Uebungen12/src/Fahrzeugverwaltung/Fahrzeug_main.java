package Fahrzeugverwaltung;
import java.util.Vector;

public class Fahrzeug_main
{

	public static void main(String[] args) {
		//Author Felix
		
		Fahrzeug f = new Fahrzeug(30);
		Auto a = new Auto(240, 150);
		Lastwagen l = new Lastwagen(150, 250, 30);
		Fahrrad r = new Fahrrad(33);
		Object o = new Fahrzeug();
		Vector v = new Vector();
		v.addElement(o);
		v.addElement(f);
		v.addElement(a);
		v.addElement(l);
		v.addElement(r);
		java.util.Enumeration e = v.elements();
		while (e.hasMoreElements()) {
		Fahrzeug x = (Fahrzeug)e.nextElement();
		System.out.println(x.toString());
		}


	}

}
