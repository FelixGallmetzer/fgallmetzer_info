
public class TestArray
{

	public static void printIntArray(String msg, int[] a) {
		System.out.print(msg + " =  {");
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				System.out.print(a[i]);
			} else {
				System.out.print(a[i] + ", ");
			}
		}
		System.out.println("}");
	}

	/**
	 * braucht 3 int und generiert ein Array mit zufällig int Werten.
	 * 
	 * @param int
	 *          anzahl gibt an wieviele Elemente das Array haben soll.
	 * @param int
	 *          von die kleinste mögliche random Zahl.
	 * @param int
	 *          bis die größte mögliche random Zahl.
	 * @return das zufällig generierte Array
	 */
	public static int[] randomIntArray(int anzahl, int von, int bis) {
		int[] ret = null;
		ret = new int[anzahl];
		for (int i = 0; i < anzahl; i++) {
			int random = von + (int) (Math.random() * ((bis - von) + 1));
			ret[i] = random;
		}
		return ret;
	}

	/**
	 * braucht ein Array von welchem es die kleinste Zahl raus liest.
	 * 
	 * @param int[]
	 *          a Array aus welchem das Minimum gelesen werden soll
	 * @return kleinste Zahl
	 */
	public static int getMinimum(int[] a) {
		int ret = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < ret) {
				ret = a[i];
			}
		}
		return ret;
	}

	/**
	 * braucht ein Array von welchem es die größte Zahl raus liest.
	 * 
	 * @param int[]
	 *          a Array aus welchem das Maximum gelesen werden soll
	 * @return größte Zahl
	 */
	public static int getMaximum(int[] a) {
		int ret = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > ret) {
				ret = a[i];
			}
		}
		return ret;
	}

	/**
	 * braucht ein Array von welchem es die mittlere Zahl raus liest.
	 * 
	 * @param int[]
	 *          a Array aus welchem der Mittelwert gelesen werden soll
	 * @return mittlere Zahl
	 */
	public static double getMittelwert(int[] a) {
		double ret = 0;
		for (int i = 0; i < a.length; i++) {
			ret += a[i];
		}
		return ret / a.length;
	}

	/**
	 * gibt die Position von z im Array a zurück. Wird z nicht gefunden, dann wird
	 * -1 zurückgeben.
	 * 
	 * @param int[]
	 *          a Array in welchem z gesucht wird.
	 * @param int
	 *          z Zahl, welche in a gesucht wird.
	 * @return Position von z.
	 */
	public static int indexOf(int[] a, int z) {
		int ret = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == z) {
				ret = i;
				i = a.length;
			}
		}
		return ret;
	}

	/**
	 * gibt die Position von z im Array a ab pos zurück. Wird z nicht gefunden, dann
	 * wird -1 zurückgeben.
	 * @param int[] a Array in welchem z gesucht wird.
	 * @param int z Zahl, welche in a gesucht wird.
	 * @param int pos Index, von wo aus z gesucht wird.
	 * @return Position von z.
	 */
	public static int indexOf(int[] a, int z, int pos) {
		int ret = -1;
		for (int i = pos; i < a.length; i++) {
			if (a[i] == z) {
				ret = i;
				i = a.length;
			}
		}
		return ret;
	}

	/**
	 * Gibt das kleinste Element des Arrays inklusive der Position des Elements
	 * zurück. und ab pos sucht.
	 * 
	 * @param int[]
	 *          a Array in welchem z gesucht wird.
	 * @param int
	 *          z Zahl, welche in a gesucht wird.
	 * @param int
	 *          pos Index, von wo aus z gesucht wird.
	 * @return Position von z.
	 */
	public static int getMinPos(int[] a, int pos) {
		int ret = a[pos];
		for (int i = pos; i < a.length; i++) {
			if (a[i] < ret) {
				ret = a[i];
			}
		}
		ret = indexOf(a, ret, pos);
		return ret;
	}

	/**
	 * Jedes Element im Array a wird um den Integer z erhöht.
	 * 
	 * @param int[]
	 *          a Array mit den Elementen die erhöht werden.
	 * @param int
	 *          z Zahl, mit der erhöht wird.
	 */
	public static void addZahl(int[] a, int z) {
		for (int i = 0; i < a.length; i++) {
			a[i] += z;
		}
	}

	/**
	 * Ersetzt das Element im Array a an der Position i mit dem Element an der
	 * Position j
	 * 
	 * @param int[]
	 *          a Array mit den Elementen die vertauscht werden.
	 * @param int
	 *          i 1. Element.
	 * @param int
	 *          j 2. Element.
	 */
	public static void swap(int[] a, int i, int j) {
		int b = a[i];
		int c = a[j];
		a[i] = c;
		a[j] = b;
	}

	/**
	 * Mit getMinPos sucht man die kleinste zahl und vertauscht diese mit Element an
	 * Position 1 und so weiter.
	 * 
	 * @param int[]
	 *          a Array, welches sortiert wird.
	 */
	public static void sortMinArray(int[] a) {
		int b = 0;
		for (int i = 0; i < a.length; i++) {
			b = getMinPos(a, i);
			swap(a, i, b);
		}
	}

	/**
	 * Das angegebene Array wird kopiert, und alle doppelte darin werden gelöscht.
	 * bspw. 1,1,2,2,3 wird zu 1,2,3.
	 * 
	 * @param int[]
	 *          a Array, bei welchem alle doppelten gelöscht werden.
	 * @return Array ohne doppelte.
	 */
	public static int[] delDoppelte(int[] a) {
		int[] aC = a.clone();
		int[] ret;
		int counter = 0;
		
		//alle doppelten werden durch -1 ersetzt
		for (int i = 0; i < aC.length; i++) {
			
			if (aC[i] != -1) {
				
				for (int j = i + 1; j < aC.length; j++) {
					
					if(aC[i] == aC[j]) {
						aC[j] = -1;
					}
				}
			} 
			else {
				counter++;
			}
		}
		//Das Array wird in ein kürzeres array ohne die "-1" geschrieben
		ret = new int[aC.length - counter];
		int j = 0;
		
		for (int i = 0; i < ret.length;) {
			
			if(aC[j] != -1) {
				ret[i] = aC[j];
				i++;
			}
				j++;
		}		
		return ret;
	}

}