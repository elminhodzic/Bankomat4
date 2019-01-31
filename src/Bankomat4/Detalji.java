package Bankomat4;

import java.util.ArrayList;

public class Detalji {
	
	ArrayList<Racun> listaRacuna = new ArrayList<Racun>();
	static Racun racun;
	
	public int kreirajRacun (int brojRacuna) {
		
		boolean validnostBrojaaR = true;
		racun = new Racun();
		
		if (brojRacuna < 0) {
			
			validnostBrojaaR =  false;
		}
		return brojRacuna;
		
		
	}

}
