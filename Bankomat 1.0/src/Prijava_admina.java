
public class Prijava_admina {
	static int sifra_osobe2 = 0;//tu spremam tko se prijavio
	static int l=0; //admin
		public static boolean Prijava(int sifra, int upisana_kartica) {//prijava korisnika metoda
			int c = 0;//sluzi  za provjeru da li je se osoba usjela prijaviti

			boolean a = false;//vraca stanje metode
			int brojac = 0;//sluzi kao pohrana pozicije kako bi znao koji je kroisnik pristupio
			while (a==false) {//niz za provjeru prijave kroz pozicije (i sifra i broj kartice moraju biti tocni na istoj pozicji
				if (Admin_remove_add.sifra_admina1[brojac] == sifra && Admin_remove_add.broj_admina1[brojac] == upisana_kartica ) {//uslov tocnosti
					System.out.println("Uspjesno ste pristupili vasem racunu");
					System.out.println("Dobro dosli " + Admin_remove_add.ime_admina[brojac] + " " +Admin_remove_add.prezime_admina[brojac]);
					//pohrana pozicije
	a=true;
	break;
				}
				brojac++;
				
				
				//pogreska System.out.println(c);
		
		}
		
			
			

			//pohrana u globalnoj varijabli
			sifra_osobe2 = brojac;
				Druga_pretvorba_stringa_ime.pretvorba2(Admin_remove_add.ime_admina, Admin_remove_add.prezime_admina,sifra_osobe2);//pozivanje metode koja pretvara niz imena i prezimena us tring
			
			
			return a;
		}
}
