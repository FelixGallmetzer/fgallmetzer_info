
public class WuerfelSimulator
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		System.out.println("Würfelsimulator");
		System.out.println("================");
		System.out.println("Bitte Warten");
		int i = 0;
		int z = 0;
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int a4 = 0;
		int a5 = 0;
		int a6 = 0;
		int anzahl = 1;
		while (i<1000000000) {
			z = (int) (Math.random()*6)+1;
			i++;
			if (i>(1000000000/30)*anzahl) {
				anzahl ++;
				System.out.print(".");
			}
			switch(z) {
				case 1: {
					a1++;
					break;
				}
				case 2: {
					a2++;
					break;
				}
				case 3: {
					a3++;
					break;
				}
				case 4: {
					a4++;
					break;
				}
				case 5: {
					a5++;
					break;
				}
				default: {
					a6++;
				}
			}		
		}
		System.out.println();
		System.out.println("Anzahl 1: " + a1);
		System.out.println("Anzahl 2: " + a2);
		System.out.println("Anzahl 3: " + a3);
		System.out.println("Anzahl 4: " + a4);
		System.out.println("Anzahl 5: " + a5);
		System.out.println("Anzahl 6: " + a6);
		System.out.println();
		System.out.println("Anzahl der Würfe: " + i);
	}
}
