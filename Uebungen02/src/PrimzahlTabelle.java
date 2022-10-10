public class PrimzahlTabelle
{

    public static void main(String[] args) {
    	//@Author Felix
    	//Überschrift wird ausgegeben
      System.out.println("Primzahlentabelle");
      System.out.println("=================");
      int zahl = 90;
      int n = 120;
      while (zahl <= n) {
      	printZahl(zahl);
        istPrimzahl(zahl);
        zahl ++;
      }
    } 


    public static void istPrimzahl(int z) {

    	int x= 1;
    	int n= 0;
    	//wenn es mehr als 2 Teiler gibt und x kleiner oder gleich wie die zahl ist
    	while(n<=2 && x <= z) {
    		//hiermit finden wir die Teiler
    	  if (z % x == 0) {  
    			n++;
    		}
        x++; 
    	}                                                                                             
    	System.out.println(n==2?" ist Primzahl":" ist nicht Primzahl");
    }	



    public static void printZahl(int zahl) {
    	if (zahl < 100) {
    		System.out.print("  " + zahl);
    		}
    	else if (zahl < 1000) 
      	System.out.print(" " + zahl);
    }
 }
