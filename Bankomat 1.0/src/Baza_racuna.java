import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Baza_racuna {
	static int[] racuni = new int[50];// racuni korisnika
	public static void pohrana_racuna() {//pohrana iz baze u racun
		Connection conn=sqlConnect.dbConnection();//deklariranje konekcije
		
		PreparedStatement izraz=null;
		ResultSet result=null;
		//inicijalizacija 
		try {String query ="Select Racun from Baza_korisnika  ";//uslov z abazu
			izraz=conn.prepareStatement(query);//uslov za bazu koji se prosledujuje
			result=izraz.executeQuery();//dobijanje rezultata
			int brojac=0;
			while (result.next()) {//pohrana rezultata u niz racuni u koloni racun
				racuni[brojac]=result.getInt("Racun");
				brojac++;
			}
		} catch (Exception e) {
			System.out.println("Problem u bazi, kriv uslov, izraz");
		}finally {
			try {
				izraz.close();
				result.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		
	}

	public static String get_Izvod() {// ispis izvoda
		String ispis = "";// string koji ce se ispisati pozivanjem metode

		System.out.println("Stanje na racunu " + racuni[Prijava_korisnika.sifra_osobe] + " KM");// ispis u konzolu
		ispis = "Stanje na racunu " + racuni[Prijava_korisnika.sifra_osobe] + " KM";// pohrana u varjablu ispisa ono sto
																					// cemo ispisati u GUI

		return ispis;
	}

	public static void set_Izvod(String a, int suma) {// promjena racuna korisnika

		if (a.equals("+")) {// u zavisnoti prosljedjenog argumenta (depozit ili withdraw)
			Algoritam_depozita_na_banku.prebacivanje_banka(suma);// pozivanje algoritam depozita kako bi cekirali
																	// njegovu istinistost

			if (Algoritam_depozita_na_banku.a == true) {// ukoliko je algoritam odradio posao bez problema te
														// vrijednosti prelaze u
				// racun kosirnika
				Bankomat_rad.textIspis.setText(Baza_racuna.get_Izvod() + "+" + suma);// pozivanje metode za ispis u
																						// textFiled
				racuni[Prijava_korisnika.sifra_osobe] += suma;
				Connection conn=sqlConnect.dbConnection();
				
				PreparedStatement izraz=null;
				ResultSet result=null;
				try {String query ="UPDATE  Baza_korisnika set Racun=? WHERE Sifra_kartice=?";//uslov u bazu
					izraz=conn.prepareStatement(query);
					izraz.setInt(1, racuni[Prijava_korisnika.sifra_osobe]);//promjena stanja racuna u bazu
					izraz.setInt(2, Baza_korisnika.sifra_kartice[Prijava_korisnika.sifra_osobe]);//where uslov iz izraza
					izraz.execute();
					//komunikacij sa bazm
					System.out.println("Uspjela konekcija i promjena stanja racuna");
				} catch (Exception e) {
					System.out.println("Problem u bazi, kriv uslov, izraz");
				}finally {
					try {
						izraz.close();
						result.close();
					} catch (Exception e) {
						// TODO: handle exception
					}//zatvaranje parametara za komunaickju sa bazom
					}
			}

		} else if (a.equals("-")) {// ukoliko je uslov prosljedjen zaduzen za skidanje novca sa racuna

			Algoritam_isplate.oduzimanje(suma);// algoritam skidanja novca sa racuna banke
			if (Algoritam_isplate.istinitost_oduzimanje_algoritam == true) {// ukoliko je algoritam odradio posao bez
																			// problema te
				// vrijednosti prelaze u racun kosirnika
				Bankomat_rad.textIzlaz_novca.setText(Pretvorba_niza_u_string.potreban);// ispis na GUI niz
				Bankomat_rad.textIspis.setText(Baza_racuna.get_Izvod() + "-" + suma);// pozivanje metode za ispis u
				// textFiled

				racuni[Prijava_korisnika.sifra_osobe] -= suma;// oduzimanej sa racuna korisnika
Connection conn=sqlConnect.dbConnection();
				
				PreparedStatement izraz=null;
				ResultSet result=null;
				try {String query ="UPDATE  Baza_korisnika set Racun=? WHERE Sifra_kartice=?";//uslov u bazu
					izraz=conn.prepareStatement(query);
					izraz.setInt(1, racuni[Prijava_korisnika.sifra_osobe]);//promjena stanja racuna u bazu
					izraz.setInt(2, Baza_korisnika.sifra_kartice[Prijava_korisnika.sifra_osobe]);//where uslov iz izraza
					izraz.execute();
					//komunikacij sa bazm
					System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
				} catch (Exception e) {
					System.out.println("Problem u bazi, kriv uslov, izraz");
				}finally {
					try {
						izraz.close();
						result.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
					}//zatvaranje parametara za komunaickju sa bazom
			}

		}
	}

}