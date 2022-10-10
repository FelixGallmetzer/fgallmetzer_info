
public class SummeSieben
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Author Felix
		int summe=0;
		int n=7;
		while(n<1000) {
			summe=summe + n;
			n=n + 7;
		}
		System.out.println(summe);
	}
}
