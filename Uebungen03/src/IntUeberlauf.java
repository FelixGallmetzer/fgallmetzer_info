
public class IntUeberlauf
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = Integer.MAX_VALUE;
		//dem maximalen Wert von Integer, wird mit 1 addiert sodass es überlauft und es somit negativ wird.
		max += 1;
		System.out.println(max);
	}
}
