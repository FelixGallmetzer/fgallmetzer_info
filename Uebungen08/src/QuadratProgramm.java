
public class QuadratProgramm
{

	public static void main(String[] args) {
		//@Author Felix
		int gQ = 0;
		
		Quadrat[] q = new Quadrat [49];
		
		for (int i = 0; i < 49; i++) {
			
			q[i] = new Quadrat();
		}
		
		for (int i = 0; i < 49; i++) {
			
			q[i].setSeiteA(Math.random() * 10);
			if (q[i].getSeiteA() > q[gQ].getSeiteA()) {
        gQ = i;
			}
			System.out.println(q[i].toString());
		}
		System.out.println("Größtes Quadrat: " + q[gQ].toString());
	}
}
