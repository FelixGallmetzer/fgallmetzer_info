package brueche;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BruchTest {

	Bruch bruch1;
	Bruch bruch2;
	Bruch bruch3;

	@BeforeEach
	void setUp() throws Exception {
		bruch1 = new Bruch(1, 2);
		bruch2 = new Bruch(7, 3);
		bruch3 = new Bruch(69, 420);
	}

	@Test
	void Bruch() {

		assertThrows(BruchException.class, () -> new Bruch(0, 420));
		assertEquals(2, bruch1.getZaehler());
		assertEquals(1, bruch1.getNenner());

		// Test kürzen bei Constructor
		try {
			Bruch b = new Bruch(4, 8);
			assertEquals(2, b.getZaehler());
			assertEquals(1, b.getNenner());
		} catch (BruchException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getZaehler() {
		assertEquals(2, bruch1.getZaehler());
	}

	@Test
	void setZaehler() {
		bruch1.setZaehler(100);
		assertEquals(100, bruch1.getZaehler());
	}

	@Test
	void getNenner() {
		assertEquals(1, bruch1.getNenner());
	}

	@Test
	void setNenner() {
		try {
			bruch1.setNenner(1);
		} catch (BruchException e) {
			e.printStackTrace();
		}
		assertEquals(1, bruch1.getNenner());
		assertThrows(BruchException.class, () -> bruch1.setNenner(0));
	}
	
	@Test
	void addiere() {
		try {
			bruch1.addiere(bruch2);
		} catch (BruchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(17, bruch1.getZaehler());
		assertEquals(7, bruch1.getNenner());

	}

	@Test
	void subtrahiere() {
			try {
				bruch1.subtrahiere(bruch2);
			} catch (BruchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(11, bruch1.getZaehler());
			assertEquals(7, bruch1.getNenner());
	}

	@Test
	void multipliziere() {
		try {
			bruch1.multipliziere(bruch2);
		} catch (BruchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(7, bruch1.getNenner());
		assertEquals(6, bruch1.getZaehler());
	}

	@Test
	void dividiere() {
		try {
			bruch1.dividiere(bruch2);
		} catch (BruchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, bruch1.getNenner());
		assertEquals(14, bruch1.getZaehler());
	}

	@Test
	void testToString() {
		assertEquals(bruch1.toString(), "2/1");
	}

	@Test
	void equalsBruch() {
		try {
			assertTrue(bruch1.equals(new Bruch(1, 2)));
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BruchException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testClone() {
		assertTrue(bruch1.equals(bruch1.clone()));
	}



}