
public class Prijava_korisnika extends Baza_korisnika {//prijava korisnika
	static int sifra_osobe = 0;//tu spremam tko se prijavio
static int l=0; //admin
	public static boolean Prijava(int sifra, int upisana_kartica) {//prijava korisnika metoda
		int c = 0;//sluzi  za provjeru da li je se osoba usjela prijaviti

		boolean a = false;//vraca stanje metode
		int brojac = 0;//sluzi kao pohrana pozicije kako bi znao koji je kroisnik pristupio
		while (a==false) {//niz za provjeru prijave kroz pozicije (i sifra i broj kartice moraju biti tocni na istoj pozicji
			if (sifra_kartice[brojac] == sifra && broj_kartice[brojac] == upisana_kartica ) {//uslov tocnosti
				System.out.println("Uspjesno ste pristupili vasem racunu");
				System.out.println("Dobro dosli " + ime[brojac] + " " + prezime[brojac]);
				//pohrana pozicije
a=true;
break;
			}
			brojac++;
			
			
			//pogreska System.out.println(c);
	
	}
	
		
		

		//pohrana u globalnoj varijabli
		sifra_osobe = brojac;
			Druga_pretvorba_stringa_ime.pretvorba2(ime, prezime,sifra_osobe);//pozivanje metode koja pretvara niz imena i prezimena us tring
		
		
		return a;
	}
}
