
public class Fakultaet
//@Author Felix
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int x = 1;
		int i = n;
		if (n<=0) {
			//ist n kleiner wie 0 so kann die Fakultät nicht berechnet werden deswegen wird eine Fehlermeldung ausgegeben.
			System.out.println("Bitte geben sie eine Zahl größer als 0 ein");
		}
		else {
			while(n>0) {
				x = x * n;
				n = n - 1;
			}		
		System.out.println(i + "! ergibt: " + x);	
		}
	}
}
