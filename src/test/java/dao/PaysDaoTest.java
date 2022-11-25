package dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.BeforeClass;
import org.junit.Test;

import dto.PaysDto;
import jpa.Pays;

public class PaysDaoTest {
	/** eMF */
	private static EntityManagerFactory eMF;
	/** eM */
	private static EntityManager eM;
	/** trans transaction unitaire au niveau d'un film */
//	private EntityTransaction trans;
	
	@BeforeClass  // fait en sorte que cette méthode n'est exécutée qu'une seule fois
	public static void init() {
		eMF = Persistence.createEntityManagerFactory("films");
		eM = eMF.createEntityManager();
	}
	
	// Tests avec un paramètre de type PaysDto
	@Test
	public void testPaysDaoTest1() {
		
		PaysDao.seteM(eM);
		assertNull(PaysDao.getPays((PaysDto) null));
	}
	
	@Test
	public void testPaysDaoTest2() {
		
		PaysDao.seteM(eM);
		PaysDto p1 = new PaysDto();
		p1.setNom("toto");
		Pays p = PaysDao.getPays(p1);

		assertEquals(p.getNom(), "toto");
	}
	
	@Test
	public void testPaysDaoTest3() {
		
		PaysDao.seteM(eM);
		PaysDto p1 = new PaysDto();
		
		p1.setNom("tata");
		p1.setUrl("//toto");
		Pays p = PaysDao.getPays(p1);
		assertEquals("//toto", p.getUrl());
	}

	@Test
	public void testPaysDaoTest4() {
		
		PaysDao.seteM(eM);
		PaysDto p1 = new PaysDto();
		
		p1.setNom("toto");
		p1.setUrl("//toto");
		Pays p = PaysDao.getPays(p1);
		assertNull(p.getUrl());
	}
	
	// Tests avec paramètre de type String
	@Test
	public void testPaysDaoTest5() {
		
		PaysDao.seteM(eM);
		assertNull(PaysDao.getPays((String) null));
	}
	@Test
	public void testPaysDaoTest6() {
		
		PaysDao.seteM(eM);
		Pays p = PaysDao.getPays("toto");

		assertEquals(p.getNom(), "toto");
	}
	
	@Test
	public void testPaysDaoTest7() {
		
		PaysDao.seteM(eM);
		Pays p = PaysDao.getPays("toto");

		assertEquals(p.getNom(), "toto");
	}
	
	@Test
	public void testPaysDaoTest8() {
		
		PaysDao.seteM(eM);
		Pays p = PaysDao.getPays("tata");

		assertEquals(p.getUrl(), "//toto"); // Car il retrouve tata créé avec l'objet PaysDto 
	}
		
	@Test
	public void testPaysDaoTest9() {
		
		PaysDao.seteM(eM);
		PaysDto p1 = new PaysDto();
		
		p1.setNom("toto");
		p1.setUrl("//toto");
		Pays p = PaysDao.getPays("toto");

		assertNull(p.getUrl());
	}
	
	// insertion en base
	@Test
	public void testPaysDaoTest10() {
		EntityTransaction trans;
		trans = eM.getTransaction();
		trans.begin();
		
		PaysDao.seteM(eM);
		PaysDto p1 = new PaysDto();
		
		p1.setNom("tutu");
		p1.setUrl("//tutu");
		PaysDao.getPays("tutu");
		
		trans.commit();
		
		TypedQuery<Pays> query = eM.createQuery("SELECT p FROM Pays p ", Pays.class);
		List<Pays> lPays = query.getResultList();
		
		assertEquals("tutu", lPays.get(0).getNom());
		
	}
	
	

}
