
public class Zahlenfolgen
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] z1 = {1,2,3,4,5,6,7,8};
		int[] z2 = {2,4,6,8,10,12,14,16};
		int[] z3 = {0,0,0,0,0,0,0,0,0};
		int i = 0;
		int n = z1.length;
			while (i<n) {
				z3[i] = z1[i] + z2[i]; 
				System.out.print(z3[i] + ", ");
				i++;
			}

	}

}
