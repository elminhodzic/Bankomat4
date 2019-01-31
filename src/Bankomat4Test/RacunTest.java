package Bankomat4Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import Bankomat4.Racun;

public class RacunTest {

	Racun racun;
	int brojRacuna = 1;
	String imeKorisnika = "neko";
	double iznos = 100;
	ArrayList<Racun> listaRacuna = new ArrayList<Racun>();
	
	@Before
	public void setUp () {
		
		racun = new Racun();
		racun.setBrojRacuna(brojRacuna);
		racun.setImeKorisnika(imeKorisnika);
		racun.setBalans(iznos);
		racun = new Racun(brojRacuna, imeKorisnika, iznos);
		listaRacuna.add(racun);
	}
	
	
	@Test
	public void brojRacunaTest () {
		
		assertEquals(1, racun.getBrojRacuna());
	}
	
	@Test
	public void imeKorisnikaTest () {
		
		assertEquals("neko", racun.getImeKorisnika());
	}
	
	@Test
	public void iznosRacunaTest () {
		
		assertEquals(100,0, racun.getBalans());
	}
	
	@Test
	public void konstruktorTest () {
	
		assertEquals(1, racun.getBrojRacuna());
		assertEquals("neko", racun.getImeKorisnika());
		assertEquals(100,0, racun.getBalans());
	}
	
	@Test
	public void shouldReturnTrueIfbrojRacunaIsGreathThen_0_Test () {
		
		boolean brojR = racun.ispravnostRacuna(1);
		assertTrue(brojR);
		
	}
	
	@Test
	public void shouldReturnFalseIfRacunIsLoverThen_1_Test () {
		
		boolean brojR = racun.ispravnostRacuna(-1);
		assertFalse(brojR);
	}
	
	@Test
	public void shouldReturnTrueIfalansIsGreatherThen_0_Test () {
		
		boolean balansR = racun.ispravnostBalansa(1);
		assertTrue(balansR);
	}
	
	@Test
	public void shouldReturnFalseIfBalansIsLowerThen_0_Test () {
		
		boolean balansR = racun.ispravnostBalansa(-1);
		assertFalse(balansR);
	}
	
	@Test
	public void shouldReturnTrueIFListaRacunaIsSameTest () {
		
		ArrayList<Racun> listaRacuna1 = new ArrayList<Racun>();
		Racun racun1 = new Racun(1, "neko", 100);
		listaRacuna1.add(racun);
		assertEquals(listaRacuna.get(0).getBrojRacuna(), listaRacuna1.get(0).getBrojRacuna());
		racun.listaRacunaIspis(racun);
		//assertEquals(racun1.toString(), racun.toString());
	}
	
	@Test
	public void provjeraFajlaRacuniTest () {
		
		racun.listaRacunaIspis(racun);
		File fajl = new File ("Racuni.txt");
		try {
			Scanner skaner = new Scanner (fajl);
			
			while (skaner.hasNext()) {
				
				brojRacuna = skaner.nextInt();
				assertEquals(1, brojRacuna);
				imeKorisnika = skaner.next();
				assertEquals("neko", imeKorisnika);
				iznos = skaner.nextDouble();
				assertEquals(100,0, iznos);
				
			}
			
			skaner.close();
		} catch (FileNotFoundException e) {
			
		}
	}
	
	
	@Test
	public void uplataTest () {
		
		int broRacuna =1;
		int uplata = 10;
		
		racun.uplataRacuna(1, 10);
		for (int i = 0; i < listaRacuna.size(); i++) {

			if (listaRacuna.get(i).getBrojRacuna() == broRacuna) {

				listaRacuna.get(i).setBalans(racun.getBalans() + uplata);
				
			}
		}
		
		assertEquals(110,0, listaRacuna.get(0).getBalans());
	}
	
	@Test
	public void uplataJednakostRacunaTest () {
		
		int broRacuna = 1;
		double uplata = 10;
		racun.uplataRacuna(broRacuna, uplata);
		
		assertTrue(broRacuna == listaRacuna.get(0).getBrojRacuna());
		
		for (int i = 0; i < listaRacuna.size(); i++) {

			assertTrue(broRacuna == listaRacuna.get(i).getBrojRacuna());
		}
	}

}


