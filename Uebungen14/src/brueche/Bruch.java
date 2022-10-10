package brueche;

public class Bruch
{
	
	private int nenner = 0;
	private int zaehler = 0;
	
	/**
	 * Custom Konstruktor für Bruch. Sollte nenner null sein dann wird eine BruchException ausgeworfen
	 * @param nenner
	 * @param zaehler
	 * @throws BruchException
	 */
	public Bruch(int nenner, int zaehler) throws BruchException {
		if (nenner == 0 ) {
			throw new BruchException("Nenner ist null");
		} else {
			this.nenner = nenner;
		}
		this.zaehler = zaehler;
		kuerze();
	}
	
	/**
	 * setzte den Zähler
	 * @param zaehler
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
	
	/**
	 * gibt den Zähler zurück
	 * @return zaehler
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * setzt den nenner. Sollte dieser 0 sein so wird eine BruchException geworfen.
	 * @param nenner
	 * @throws BruchException
	 */
	public void setNenner(int nenner) throws BruchException {
		if (nenner == 0 ) {
			throw new BruchException("Nenner ist null");
		} else {
			this.nenner = nenner;
			kuerze();
		}
	}
	
	/**
	 * gibt den Nenner zurück
	 * @return nenner
	 */
	public int getNenner() {
		return nenner;
	}
	
	/**
	 * kürzt den Bruch
	 */
	private void kuerze() {
		int ggt;
		 while((ggt = getGGT(this.nenner, this.zaehler)) > 1) {
			 this.nenner = this.nenner/ggt;
			 this.zaehler = this.zaehler/ggt;
		 }
	}
	
	/**
	 * kopiert aus GeeksForGeeks
	 * URL: https://www.geeksforgeeks.org/java-program-to-compute-gcd/
	 * @param a
	 * @param b
	 * @return ggt
	 */
  public int getGGT(int a, int b) {
    // stores minimum(a, b)
    int i;
    if (a < b)
        i = a;
    else
        i = b;

    // take a loop iterating through smaller number to 1
    for (i = i; i > 1; i--) {

        // check if the current value of i divides both
        // numbers with remainder 0 if yes, then i is
        // the GCD of a and b
        if (a % i == 0 && b % i == 0)
            return i;
    }
    // if there are no common factors for a and b other
    // than 1, then GCD of a and b is 1
    return 1;
  }	
  
  public String toString() {
  	return (this.zaehler + "/" + this.nenner);
  }
  
  public boolean equals(Object b2) {
  	boolean ret = false;
  	if (b2 == null) {
  		throw new NullPointerException("Zweiter Bruch leer");
  	} else if (b2 instanceof Bruch) {
  		if (this.nenner == ((Bruch) b2).nenner && this.zaehler == ((Bruch) b2).zaehler) {
  			ret = true;
  		}
  	} else {
  		throw new ClassCastException("Typen nicht passned");
  	}
  	return ret;
  }
  
  public Bruch clone () {
  	Bruch bruch;
		try {
			bruch = new Bruch(this.nenner, this.zaehler);
		} catch (BruchException e) {
			return null;
		}
  	return bruch;
  }
  
  /**
   * addiert 2 Brüche
   * @param b
   * @throws BruchException
   */
  public void addiere(Bruch b) throws BruchException {
  	if (b == null) {
  		throw new NullPointerException("Zweiter Bruch leer");
  	} else {
	  	int gnenner = this.nenner*b.nenner;
	  	int gzaehler = this.zaehler*b.nenner + b.zaehler*this.nenner;
	  	this.setZaehler(gzaehler);
	  	this.setNenner(gnenner);
  	}
  }
  
  /**
   * subtrahiert 2 Brüche
   * @param b
   * @throws BruchException
   */
  public void subtrahiere(Bruch b) throws BruchException {
  	if (b == null) {
  		throw new NullPointerException("Zweiter Bruch leer");
  	} else {
  		if (this.nenner == b.nenner) {
  			int gzaehler = this.zaehler - b.zaehler;
  			this.setZaehler(gzaehler);
  		} else {
  			int gnenner = this.nenner*b.nenner;
  			int gzaehler = this.zaehler*b.nenner - b.zaehler*this.nenner;
  			this.setZaehler(gzaehler);
  			this.setNenner(gnenner);
  		}
  	}
  }
  
  /**
   * multipliziert 2 Brüche
   * @param b
   * @throws BruchException
   */
  public void multipliziere(Bruch b) throws BruchException {
  	if (b == null) {
  		throw new NullPointerException("Zweiter Bruch leer");
  	} else {
  		int gnenner = this.nenner * b.nenner;
  		int gzaehler = this.zaehler*b.zaehler;
  		this.setZaehler(gzaehler);
  		this.setNenner(gnenner);
  	}
  }
  
  /**
   * dividiert 2 Brüche
   * @param b
   * @throws BruchException
   */
  public void dividiere(Bruch b) throws BruchException {
   	if (b == null) {
  		throw new NullPointerException("Zweiter Bruch leer");
  	} else {
  		int gnenner = this.nenner * b.zaehler;
  		int gzaehler = this.zaehler*b.nenner;
  		this.setNenner(gnenner);
  		this.setZaehler(gzaehler);
  	}
  }
}
