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
	private int brojPoruka = 40;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		
		for (int i = 0; i < brojPoruka; i++) {
			t.unesi("Jeca", "Poyy");
		}
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
		assertEquals(brojPoruka, t.vratiSvePoruke().size());
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
		assertEquals(24, t.vratiPoruke(24, "bla").length);
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
		assertEquals(100, t.vratiPoruke(0, "bla").length);
	}

}
