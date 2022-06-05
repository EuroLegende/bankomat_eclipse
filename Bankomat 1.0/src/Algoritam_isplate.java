import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Algoritam_isplate extends Baza_novca_bankomat {
	static int[] niz_novca = new int[24];// niz u koji se prosljeduje suma novca koja je uplacena po novcanicama
static boolean istinitost_oduzimanje_algoritam=true;;
	public static int[] oduzimanje(int kolicina_isplate) {// metoda za skidanje novca sa racuna i iz banke
		try {
			int x = 10;
			int xx = 20;
			int l = 50;
			int m = 100;
			int z = 200;
			// deklariranje osnovnih vrijednosti novcanica
			int brojac = 0;// brojac pomocu kojeg se pohranjuju vrijednosti u niz
			if (kolicina_isplate > Baza_novca_bankomat.ukupno_stanje) {
				istinitost_oduzimanje_algoritam = false;//uslov za prekid algoritam (hoce vise novca nego sto ima
				JOptionPane.showMessageDialog(null, "Bankomat trenutno nema toliko novca za isplatu");
				throw new InputMismatchException("Bankomat trenutno nema toliko novca za isplatu");

			}
			while (kolicina_isplate != 0) {// petlja koja vrsi algoritam do potpune ispraznosti kolicine koju korisnik
											// trazi od banke

				if (kolicina_isplate >= z && dvjesto > 0) {
					kolicina_isplate -= z;// snizavanje te sume isplate
					dvjesto--; // skidanje novcanice sa banke
					niz_novca[brojac] = z;
					ukupno_stanje -= z;// spremanje novcanice u niz
				} else if (kolicina_isplate >= m && sto > 0) {
					kolicina_isplate -= m;
					ukupno_stanje -= m;
					sto--;
					niz_novca[brojac] = m;
				} else if (kolicina_isplate >= l && pedeset > 0) {
					kolicina_isplate -= l;
					ukupno_stanje -= l;
					pedeset--;
					niz_novca[brojac] = l;
				} else if (kolicina_isplate >= xx && dvadeset > 0) {
					kolicina_isplate -= xx;
					ukupno_stanje -= xx;
					dvadeset--;
					niz_novca[brojac] = xx;
				} else if (kolicina_isplate >= x && deset > 0) {
					kolicina_isplate -= x;
					deset--;
					niz_novca[brojac] = x;
					ukupno_stanje -= x;
				} else {
					// ukoliko se radi o svoti koju bankomat ne moze uzeti kroz novcanice bacamo
					// gresku u sistem kako bi
				// ponistili isplatu sa banke i zaustavili algoritam (drugi uslov zaustavljanja)
				istinitost_oduzimanje_algoritam = false;
				throw new InputMismatchException("Unjeli ste svotu novca koju bankomat ne moze primiti");

			}
				brojac++;// povecanje pozicije u nizu
			}
			
			Baza_novca_bankomat.popuna_baze();// popuna baze sa novim virsjenostima
			Pretvorba_niza_u_string.pretvorba(niz_novca);// pretvorba niza u string zbig ispisa stringa(textFiled)
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unjeli ste svotu novca koju bankoma ne moze isplatiti!");
		}

	return niz_novca;
	}

	public static void provjera_uslova_isplate(int suma) {// meotoda uslova
	
		if (suma > 1000 || suma > Baza_racuna.racuni[Prijava_korisnika.sifra_osobe]) {
			
			JOptionPane.showMessageDialog(null, "Unjeli ste preveliku svotu novca!");
			throw new InputMismatchException("Unjeli ste preveliku svotu novca!");
		} else if (suma <= 0) {
			
			JOptionPane.showMessageDialog(null, "Unjeli ste premalu svotu novca!");
			throw new InputMismatchException("Unjeli ste premalu svotu novca!");
		} else if (suma % 10 != 0) {
			
			JOptionPane.showMessageDialog(null, "Unjeli ste svotu novca koju bankomat ne moze isplatiti(sitni novac)!");
			throw new InputMismatchException("Unjeli ste svotu koju ne mozemo isplatiti (neparni brojevi)");
		} else if (suma > Baza_novca_bankomat.ukupno_stanje) {
			
			JOptionPane.showMessageDialog(null, "Bankomat trenutno nema toliko novca za isplatu");
			throw new InputMismatchException("Bankomat trenutno nema toliko novca za isplatu");

		}

		else {

			Baza_racuna.set_Izvod("-", suma);
			

		}
		
	}
}
