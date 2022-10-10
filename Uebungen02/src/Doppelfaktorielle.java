
public class Doppelfaktorielle
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		int n = Integer.parseInt(args[0]);
		int x = 1;
		int i = n;
		//es wird geprüft ob n gültig ist
		if (n>0) {		
			//es wird geprüft ob n gerade oder ungerade ist
			if(n%2 == 0 && n>=2) {
				while(n>0) {
					x = x*n;
					n = n-2;				
				}
			}
			//falls n ungerade ist, so wird dies in Kraft treten
			else if (n%2 != 0 && n>=1) {
				while(n>0) {
					x = x*n;
					n = n-2;
				}		
			}
			System.out.println(i + "! ergibt: " + x);
		}
		else {
			System.out.println("Bitte geben sie einen Wert über 0 ein!");
		}

	}

}
