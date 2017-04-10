/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Korisnik
 *
 */
public class TwitterTest {

	private Twitter t;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		for (int i = 0; i < 5; i++) {
			t.unesi("Jeca", "Poyy");
		}
		
		assertEquals(5 , t.vratiSvePoruke().size());
		
		LinkedList<TwitterPoruka> tp = t.vratiSvePoruke();
		
		for(int i = 0; i < tp.size(); i++) {
			assertEquals("Jeca", tp.get(i).getKorisnik());
			assertEquals("Poyy", tp.get(i).getPoruka());
		}
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		t.unesi("Jeca", "Poyy");
		
		LinkedList<TwitterPoruka> poruke = t.vratiSvePoruke();
		assertEquals("Jeca", poruke.getLast().getKorisnik());
		assertEquals("Poyy", poruke.getLast().getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		t.unesi("Jeca", "Poyy");
		t.unesi("Mika", "Cao");
		t.unesi("Gogi", "Poyy");
		t.unesi("Joca", "Cao");
		t.unesi("Sale", "Poyy");
		
		assertEquals(2 , t.vratiPoruke(2, "Poy").length);
		
		TwitterPoruka[] nizPoruka = new TwitterPoruka[2];
		nizPoruka = t.vratiPoruke(2, "Poy");
		
		assertEquals("Jeca", nizPoruka[0].getKorisnik());
		assertEquals("Poyy", nizPoruka[0].getPoruka());
		assertEquals("Gogi", nizPoruka[1].getKorisnik());
		assertEquals("Poyy", nizPoruka[1].getPoruka());
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		t.vratiPoruke(15, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagEmpty() {
		t.vratiPoruke(15, "");
	}
	
	@Test 
	public void testVratiPorukeMaxBroj() {
		
		for (int i = 0; i < 110; i++) {
			t.unesi("Jeca", "bla");
		}
		
		assertEquals(100, t.vratiPoruke(0, "bla").length);
	}

}
