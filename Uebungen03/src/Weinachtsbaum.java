
public class Weinachtsbaum
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		int h = 15;
		int s = 3;
		int a = h;
		int j = 0;
		int k = 1;
		int i = 0;
		//es wird hier der obere Teil des Baumes gezeichnet
		while(i<h) {
			printLeerzeichen(h-1);
			printSterne(k);
			printLeerzeichen(h-1);
			System.out.println();
			h--;
			k+=2;
		}
		//hier wird der Stamm gezeichnet
		while (j<s) {
			printLeerzeichen(a-2);
			printSterne(3);
			printLeerzeichen(a-2);
			System.out.println();
			j++;			
		}
	}
	//hiermit werden die Punkte gesetzt
	public static void printLeerzeichen (int anzahl) {
		while (anzahl>0) {
			System.out.print(" ");
			anzahl--;
		}
	}
	//hiermit werden die Sterne gesetzt
	public static void printSterne (int anzahl) {
		while (anzahl>0) {
			System.out.print("*");
			anzahl--;
		}
	}
}
