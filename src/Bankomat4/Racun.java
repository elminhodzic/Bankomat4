package Bankomat4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Racun implements Serializable {

	private int brojRacuna;
	private String imeKorisnika;
	private double balans;

	ArrayList<Racun> listaRacuna = new ArrayList<Racun>();

	public Racun() {

	}

	/**
	 * @param brojRacuna
	 * @param imeKorisnika
	 * @param balans
	 */
	public Racun(int brojRacuna, String imeKorisnika, double balans) {
		super();
		this.brojRacuna = brojRacuna;
		this.imeKorisnika = imeKorisnika;
		this.balans = balans;
		// listaRacuna.add(this);
	}

	public boolean ispravnostRacuna(int brojRacuna) {

		if (brojRacuna < 0) {

			return false;
		}

		return true;
	}

	public boolean ispravnostBalansa(double balans) {

		if (balans < 0) {

			return false;
		}

		return true;
	}

	public ArrayList<Racun> listaRacunaIspis(Racun racun) {

		File fajl = new File("Racuni.txt");
		try {
			Scanner skaner = new Scanner(fajl);

			while (skaner.hasNext()) {

				this.brojRacuna = skaner.nextInt();
				this.imeKorisnika = skaner.next();
				this.balans = skaner.nextDouble();
				listaRacuna.add(this);
			}

		} catch (FileNotFoundException e) {

			System.out.println("Fajl ne postoji");
			e.printStackTrace();
		}

		return listaRacuna;
	}

	public boolean uplataRacuna(int broRacuna, double uplata) {

		for (int i = 0; i < listaRacuna.size(); i++) {

			if (listaRacuna.get(i).getBrojRacuna() == broRacuna) {

				if (uplata > 0) {
				listaRacuna.get(i).balans += uplata;
				System.out.println("oplata izvrsena");
				return true;
				}else {
					System.out.println("negativan iznos");
				}
			}else {
				System.out.println("broj ne postoji u bazi");
			}
		}
		return false;
		
	}

	/**
	 * @return the brojRacuna
	 */
	public int getBrojRacuna() {
		return brojRacuna;
	}

	/**
	 * @param brojRacuna the brojRacuna to set
	 */
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	/**
	 * @return the imeKorisnika
	 */
	public String getImeKorisnika() {
		return imeKorisnika;
	}

	/**
	 * @param imeKorisnika the imeKorisnika to set
	 */
	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	/**
	 * @return the balans
	 */
	public double getBalans() {
		return balans;
	}

	/**
	 * @param balans the balans to set
	 */
	public void setBalans(double balans) {
		this.balans = balans;
	}

}
