
public class DoubleUeberlauf
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		double max = Double.MAX_VALUE;
		int i = 0;
		//es wird eine Schleife zum addieren von Zahlen an max ausgeführt
		while (i<=100000) {
			max += 1E300;
			i++;
		}
		System.out.println(max);
	}
}
