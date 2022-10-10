
public class potenz
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = TestScannerErweitert.readInt("geben sie die Basis ein: ");
		int z = TestScannerErweitert.readInt("Geben Sie die Hochzahl ein: ");
		int y = potenz(x,z);
		System.out.println(y);
		
	}

	
	public static int potenz (int basis, int exp) {
	
		int ret = 1;
		if (exp > 0) {
			ret = basis * potenz(basis, exp - 1);
		}
		return ret;
	}
}
