
public class TestTestArray
{

	public static void main(String[] args) {
		// @Author Felix
		int [] a = TestArray.randomIntArray(15,5,10);
		TestArray.printIntArray("a", a);
		System.out.println(TestArray.getMinimum(a));
		System.out.println(TestArray.getMaximum(a));
		System.out.println(TestArray.getMittelwert(a));
		System.out.println(TestArray.indexOf(a, 5));
		System.out.println(TestArray.indexOf(a, 5, 5));
		int [] b = TestArray.randomIntArray(5,1,10);
		TestArray.printIntArray("b", b);
		System.out.println(TestArray.getMinPos(b, 2));
		int [] c = TestArray.randomIntArray(10,0,9);
		TestArray.printIntArray("c", c);
		TestArray.addZahl(c,100);
		TestArray.printIntArray("c + 100", c);
		int [] d = TestArray.randomIntArray(3,1,10);
		TestArray.printIntArray("d", d);
		TestArray.swap(d, 0, 2);
		TestArray.printIntArray("d swapped", d);
		int [] e = TestArray.randomIntArray(50, 1, 100000);
		TestArray.printIntArray("e", e);
		TestArray.sortMinArray(e);
		TestArray.printIntArray("e sortiert", e);
		int [] f = TestArray.randomIntArray(50, 0, 10);
		TestArray.printIntArray("f", f);
		f = TestArray.delDoppelte(f);
		TestArray.printIntArray("fdeldoppelte", f);
		
	}
}
