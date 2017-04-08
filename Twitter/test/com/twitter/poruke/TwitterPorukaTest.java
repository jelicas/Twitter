/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jelica Stanojevic
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka p;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		p = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		p.setKorisnik("Jeca");
		
		assertEquals("Jeca", p.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		p.setKorisnik(null);	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		p.setKorisnik("");	
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		p.setPoruka("Poyy");
		
		assertEquals("Poyy", p.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		p.setPoruka(null);
	}
	
	@Test  (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		p.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaSaViseOd140Karaktera() {
		String poruka = "";
		for (int i = 0; i < 150; i++) {
			poruka += "a";
		}
		p.setPoruka(poruka);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		p.setKorisnik("Mika");
		p.setPoruka("Caos");
		
		assertEquals("KORISNIK:Mika PORUKA:Caos", p.toString());
	}

}
