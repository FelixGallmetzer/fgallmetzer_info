
public class Kartentrick_Methoden
{

	/*
	 * Das eingegeben Array wird in einer Spalte ausgeteilt und in einer
	 * Reihe wieder eingesammelt.
	 * Falls b 0 ist oder a null entspricht, so wird ein neues Array
	 * generiert und ausgegeben.
	 * @param Array, welches einzusammeln ist
	 * @param Integer, welcher angibt welche Reihe als erstes 
	 * eingesammelt wird
	 * @return Das eingesammelte Array 
	 */
	public static int[][] fuellen(int[][] a, int b) {
		//@Author Felix
		
		int[][] ret = new int[7][3];
		if (a == null || b == 0) {
			
			System.out.println("Kartentrick");
			System.out.println("===========");
			
			for (int i = 0; i < 7; i++) {
				
				for (int j = 0; j < 3; j++){
					ret [i][j] = i + (7 * j) + 1;
				}
			}
		}
		
		else 
			
			if (b == 1) {
				int c = 0;
				int d = 2;
				
				for (int i = 0; i < 7; i++ ) {
					
					for (int j = 0; j < 3; j++) {
						ret [i][j] = a [c][d];
						if (c < 7) {
							c += 1;
						}
						if (c == 7) {
							d += 1;
							c = 0;
							if (d == 3) {
								d = 0;
							}
						}
					}
				}
			}
		
		else
			
			if(b == 2) {
				int c = 0;
				int d = 0;
				
				for (int i = 0; i < 7; i++) {
					
					for (int j = 0; j < 3; j++) {
						ret [i][j] = a [c][d];
						if (c < 7) {
							d += 1;
							c = 0;
						}
					}
				}
			}
		

		return ret;
	}
	/*
	 * Das Array a wird ausgegeben
	 * @param Das Array, welches ausgegeben werden soll
	 */
	public static void ausgeben(int[][] a) {
		//@Author Felix
		
		for(int i = 0; i < 7; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				if(a [i][j] > 9) {
					System.out.print(" " + a [i][j]);
					
				}
				else {
					System.out.print("  " + a [i][j]);
				}	
			}
			System.out.println();
		}
	
	}
}