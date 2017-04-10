package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa za citanje i pisanje korisnikovih poruka
 * @author Jelica Stanojevic
 * @version 1.0
 */
public class Twitter {

	/**
	 * Atribut koji predstavlja listu twitter poruka
	 * Tip objekta u listi:
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda za vracanje svih poruka
	 * @return poruke - LinkedList poruka datih objekta:
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}


	/**
	 * Metoda za unos poruke odgovarajuceg korisnika u listu poruke.
	 * @param korisnik - ime korisnika kao String
	 * @param poruka - tekst poruke kao String
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		//"korisnik" promenjen u korisnik
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);

		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda za vracanje odgovarajuceg broja poruka u nizu ako sadrze odgovarajuci tag
	 * @param maxBroj - maksimalan broj poruka koje treba da vratimo, ako je manji ili jednak od 0 postavlja se na 100
	 * @param tag - odgovarajuci tag u poruci
	 * @throws java.lang.RuntimeException ako:
	 * <ul>
	 * 		<li>tag == null</li>
	 * 		<li>tag je prazan String</li>
	 * </ul>
	 * @return rezultat - niz odgovarajucih poruka	
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {

		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");

		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;

		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;

		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					//ispravljena greska u kodu
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		
		return rezultat;
	}
} 