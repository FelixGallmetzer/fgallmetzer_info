public class Person 
//Author Felix
{
	//Variablen
	public int nummer;
	public static int naechstenummer = 0;
	private String vorname;
	private String nachname;
	private boolean weiblich;
	private Person mutter;
	private Person vater;
	
	//Custom Konstruktor
	public Person (String vn, String nn, boolean weiblich) {
		this.nummer = naechstenummer;
		this.setVorname(vn);
		this.setNachname(nn);
		this.setWeiblich(weiblich);
		this.mutter = null;
		this.vater = null;
		naechstenummer++;
	}
	
	//Custom Konstruktor
	public Person (String vn, String nn, boolean weiblich, Person mutter, Person vater) {
		this(vn, nn, weiblich);
		if (mutter != null) {
			this.setMutter(mutter);
		}
		if (vater != null) {
			this.setVater(vater);
		}
	}
	
	//Kopier Konstruktor
	public Person (Person p) {
		this(p.vorname,p.nachname, p.weiblich);
		this.mutter = null;
		this.vater = null;
		this.nummer = p.nummer;
		this.naechstenummer = p.naechstenummer;
	}

	/*
	 * @return Vor- und Nachname getrennt mit einem Leerzeichen
	 */
	public String Name() {
		String ret = this.vorname + " " + this.nachname;
		return ret;
	}
	
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return the weiblich
	 */
	public boolean getWeiblich() {
		return weiblich;
	}

	/**
	 * @param weiblich the weiblich to set
	 */
	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}

	/**
	 * @return the mutter
	 */
	public Person getMutter() {
		return mutter;
	}

	/**
	 * @param mutter the mutter to set
	 */
	public void setMutter(Person mutter) {
		if (mutter.weiblich) {
			this.mutter = mutter;
		}
	}

	/**
	 * @return the vater
	 */
	public Person getVater() {
		return vater;
	}

	/**
	 * @param vater the vater to set
	 */
	public void setVater(Person vater) {
		if (!vater.weiblich) {
			this.vater = vater;
		}
	}
	
	/*
	 * gibt eine Person als String zurück.
	 * @return Person als String
	 */
	public String toString () {
		String ret = this.nummer + ": " + this.Name() + " w = " + this.getWeiblich() + " m = " + ((this.mutter != null) ? this.mutter.Name() : "null") + " v = " + ((this.vater != null) ? this.vater.Name() : "null");
		return ret;
	}
	
	public Person[] getEltern() {
		Person[] ret = new Person[2];
		
		if (this.mutter != null) {
			ret[0] = new Person(this.mutter);
		} else {
			ret [0] = null;
		}
		
		if (this.vater != null) {
			ret[1] = new Person(this.vater);
		} else {
			ret [1] = null;
		}
		
		return ret;
	}
	
	public Person[] getGrosseltern() {
		Person[] ret = new Person[4];
		
		if (this.mutter.mutter != null) {
			ret[0] = new Person(this.mutter.mutter);
		} else {
			ret [0] = null;
		} 
		
		if (this.mutter.vater != null) {
			ret[1] = new Person(this.mutter.vater);
		} else {
			ret [1] = null;
		} 
		
		if (this.vater.mutter != null) {
			ret[2] = new Person(this.vater.mutter);
		} else {
			ret [2] = null;
		} 
		
		if (this.vater.vater != null) {
			ret[3] = new Person(this.vater.vater);
		} else {
			ret [3] = null;
		} 
		
		return ret;
	}
	
	public String getListe() {
		String ret = this.toString() + ((this.mutter != null) ? "\n" + this.mutter.getListe() : "") + ((this.vater != null) ? "\n" + this.vater.getListe() : "");
				
		return ret;
	}

}
