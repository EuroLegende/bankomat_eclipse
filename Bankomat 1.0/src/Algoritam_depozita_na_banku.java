import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Algoritam_depozita_na_banku extends Baza_novca_bankomat {
	static boolean a = true;// stanje koje se prosljedjuje u bazu racuna(da li je moguce izvrsiti depozit na
							// banku)
	static int[] niz_novca_depozit = new int[24];// niz u koji se prosljeduje suma novca koja je uplacena po novcanicama

	public static int[] prebacivanje_banka(int suma) {// depozit sa uplate na banku i racun

		try {
			int depozit = suma;// suma koju je korisnik unjeo kao depozit
			System.out.println(depozit);// ispis o kojoj se sumi radi zbog provjere da li algoritam negira i potvrudjuje
										// dobro (debug)
			int x = 10;
			int xx = 20;
			int l = 50;
			int m = 100;
			int z = 200;
			// deklariranje osnovnih vrijednosti novcanica
			int brojac = 0;
			// brojac pomocu kojeg se pohranjuju vrijednosti u niz
			while (depozit != 0) {// petlja koja vrsi algoritam do potpune ispraznosti depozita od korisnika na
									// racun
				if (dvjesto != 30 && depozit >= 200) {
					dvjesto++;// dodavanje novcanice na bankomat
					ukupno_stanje += z;// podizanje vrijednosti ukupnog stanja
					depozit -= z;// uzimanje novca od korisnika u toj vrijednosti n0vcanice
					niz_novca_depozit[brojac] = z;// pohrana za niz
				} else if (sto != 40 && depozit >= 100) {
					sto++;
					depozit -= m;
					ukupno_stanje += m;
					niz_novca_depozit[brojac] = m;
				} else if (pedeset != 40 && depozit >= 50) {
					pedeset++;
					depozit -= l;
					ukupno_stanje += l;
					niz_novca_depozit[brojac] = l;
				} else if (dvadeset != 30 && depozit >= 20) {
					dvadeset++;
					ukupno_stanje += xx;
					depozit -= xx;
					niz_novca_depozit[brojac] = xx;
				} else if (deset != 30 && depozit >= 10) {
					deset++;
					depozit -= x;
					ukupno_stanje += x;
					niz_novca_depozit[brojac] = x;
				} else {// ukoliko se radi o svoti koju bankomat ne moze uzeti kroz novcanice bacamo
						// gresku u sistem kako bi
					// ponistili depozit na banku i zaustavili algoritam (drugi uslov zaustavljanja)
					a = false;
					throw new InputMismatchException("Unjeli ste svotu novca koju bankomat ne moze primiti");

				}
				brojac++;// rast brojaca za jednu pozicijiu
			}
			Pretvorba_niza_u_string.pretvorba(niz_novca_depozit);// pozivanje metode koja pretvara niz u string kako bi
																	// se mogao ispisati u string izrazu(textField)
	
			Baza_novca_bankomat.popuna_baze();// popuna baze novim podacima

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unjeli ste svotu novca koju bankoma ne moze primiti!");
		}

		return niz_novca_depozit;// vracanje niza koji je pohranio novcanice
	}

	public static void provjera_uslova_depozita(int suma) {// meotoda uslova kada je moguce uraditi depozit 
		
		if (suma > 1000) {
			
			JOptionPane.showMessageDialog(null, "Unjeli ste preveliku svotu novca!");
			throw new InputMismatchException("Unjeli ste preveliku svotu novca!");
		} else if (suma <= 0) {
			
			JOptionPane.showMessageDialog(null, "Unjeli ste premalu svotu novca!");
			throw new InputMismatchException("Unjeli ste premalu svotu novca!");
		} else if (suma % 10 != 0) {//uslov za cifre koje imaju jedinice u sebi
			
			JOptionPane.showMessageDialog(null, "Unjeli ste svotu novca koju bankomat ne mote primiti");
			throw new InputMismatchException("Unjeli ste svotu koju ne mozemo isplatiti (neparni brojevi)");
		}

		else {//ukoliko su uslovi ispunjeni suma se prosljeduje u bazu racuna
			
			

			Baza_racuna.set_Izvod("+", suma);

		}
	
	}
}
