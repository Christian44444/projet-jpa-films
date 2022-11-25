package jpa;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaysTest {

	@Test
	public void testPaysTest1() {
		Pays p = new Pays();
		p.setNom("George");
		p.getFilms().add(null);
		
		assertNotEquals("Tomas", p.getNom());
	}
	@Test
	public void testPaysTest2() {
		Pays p = new Pays();
		p.setNom(null);
		p.getFilms().add(null);
		
		assertNotNull(p);
	}

}
