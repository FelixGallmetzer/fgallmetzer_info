
public class PersonTest
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person[] p = new Person[15];
		p[0] = new Person("Franz", "Amonn", false, null, null);
		p[1] = new Person("Astrid", "Prenn", true, null, null);
		p[2] = new Person("Sepp", "Amonn", false, p[1], p[0]);
		p[3] = new Person("Erwin", "Pircher", false, null, null);
		p[4] = new Person("Edda", "Huber", true, null, null);
		p[5] = new Person("Elsa", "Pircher", true, p[4], p[3]);
		p[6] = new Person("Rudi", "Amonn", false, p[5], p[2]);
		p[7] = new Person("Martin","Seeber", false, null, null);
		p[8] = new Person("Resi", "Rüpel", true, null, null);
		p[9] = new Person("Hans", "Seeber", false, p[8], p[7]);
		p[10] = new Person("Edi", "Greif", false, null, null);
		p[11] = new Person("Anna", "Huber", true, null, null);
		p[12] = new Person("Berta", "Greif", true, p[11], p[10]);
		p[13] = new Person("Anna", "Seeber", true, p[12], p[9]);
		p[14] = new Person("Adam", "Amonn", false, p[13], p[6]);
		for (int i = 0; i < 15; i++) {
			System.out.println(p[i].toString());
		}
		System.out.println("Vater von Adam: " + p[14].getVater().Name());
		System.out.println("Großvater von Rudi mütterlicherseits: " + p[6].getMutter().getVater().Name());
		System.out.println(p[14].getEltern()[0].toString());
		System.out.println(p[14].getEltern()[1].toString());
		for (int i = 0; i < 4; i++) {
			System.out.println(p[14].getGrosseltern()[i].toString());
		}		
		System.out.println("Stammbaum:");
		System.out.println(p[14].getListe());
	}

}
