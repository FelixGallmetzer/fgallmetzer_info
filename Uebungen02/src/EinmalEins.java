public class EinmalEins
{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	  //@Author Felix
    	
        System.out.println("Einmaleins-Tabelle");
        System.out.println("==================");
        int m = 1;
        
        //Es wird durch die Schleife immer eine neue Zahl ausgegeben
        while (m<=10) {
            int r = 1;
            //Es werden neue Zeilen erstellt
            while (r<=10) {
                printZahl(m*r);
                r++;
            }
            System.out.println();
            m++;
        }
    }

    public static void printZahl(int zahl) {
     if (zahl < 10)
      System.out.print("   " + zahl);
     else
      if (zahl < 100)
       System.out.print("  " + zahl);
      else
       System.out.print(" " + zahl);
    }
}

