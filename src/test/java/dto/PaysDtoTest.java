package dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaysDtoTest {

	@Test
	public void testPaysDtoTest1() {
		PaysDto p1 = new PaysDto();
		p1.setNom("Zombieland");
		p1.setUrl("C:/toto/");
		
		assertEquals("C:/toto/", p1.getUrl());
	}

	@Test
	public void testPaysDtoTest2() {
		PaysDto p1 = new PaysDto();
		p1.setNom("Zombieland");
		p1.setUrl("C:/toto/");
		
		assertEquals("Zombieland", p1.getNom());
	}
	
	@Test
	public void testPaysDtoTest3() {
		PaysDto p1 = new PaysDto();
		p1.setNom(null);
		p1.setUrl("C:/toto/");
		
		assertNull(p1.getNom());
	}
	
	@Test
	public void testPaysDtoTest4() {
		PaysDto p1 = new PaysDto();
		p1.setNom(null);
		p1.setUrl(null);
		
		assertNull(p1.getUrl());
	}
	
	@Test
	public void testPaysDtoTest5() {
		PaysDto p1 = new PaysDto();
		
		assertNotNull(p1);
	}
	@Test
	public void testPaysDtoTest6() {
		PaysDto p1 = new PaysDto();
		p1.setNom(null);
		p1.setUrl(null);
		
		assertNotNull(p1);
	}

}
