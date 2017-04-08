package com.twitter.poruke;

/**
 * Klasa koja predstavlja twitter poruku odredjenog korisnika
 * @author Jelica Stanojevic
 * @version 1.0
 * 
 */
public class TwitterPoruka {

	/**
	 * Ime korisnika
	 */
	private String korisnik;
	
	/**
	 * Tekst poruke
	 */
	private String poruka;

	
	/**
	 * Vraca vrednost atributa korisnik 
	 * @return korisnik , njegovo ime kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Postavlja novu vrednost za atribut korisnik
	 * @param korisnik , novo ime za korisnika
	 * @throws java.lang.RuntimeException ako je uneo ime:
	 * 
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		//uslov !korisnik.isEmpty() promenjen u korisnik.isEmpty()
		//jer uslov treba da proverava kada je string prazan
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Vraca vrednost atributa poruka
	 * @return poruka , tekst poruke kao String
	 */
	public String getPoruka() {
		//"poruka" promenjeno u poruka 
		return poruka;
	}

	/**
	 * Postavlja novu vrednost za atribut poruka
	 * @param poruka , novi text poruke
	 * @throws java.lang.RuntimeException ako je uneo poruku:
	 * 
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * 		<li>String duzi od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		//skinuto this iz uslova, kao i uslov this.poruka == new String("")
		//promenjen u poruka.isEmpty()
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Vraca String sa svim podacima twitter poruke
	 * @return Ime korisnika i poruku sa odgovarajucom porukom.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}