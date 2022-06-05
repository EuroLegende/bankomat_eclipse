import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
public class Baza_korisnika extends Baza_racuna{//baza korisnika
	
	static int []broj_kartice =new int[50];
static int []sifra_kartice =new int[50];
static String []ime =new String[50];
static String []prezime=new String[50];
 
//deklarianje nizova za inforamcije o korisniku

public static void pohrana_sifre_kartice() {//pohrana sifre iz baze
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="Select Sifra_kartice from Baza_korisnika  ";//komanda za bazu
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();//deklarainaj rezultat akoji dovijamo iz baze
		int brojac=0;
		//komunkacija sa bazom
		while (result.next()) {
			sifra_kartice[brojac]=result.getInt("Sifra_kartice");//pohrana rezultata u bazu
			brojac++;//brojac koji sluzi kao pozicija u nizu
			
		}
		
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-korisnici");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	}//zatvaranje parametara za komunaickju sa bazom
	
}public static void pohrana_broja_kartice() {//pohrana broja kartice iz baze 
	//isti nacin kao i sa pohranom sifre kartice
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="Select Broj_kartice from Baza_korisnika  ";
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();
		int brojac=0;
		while (result.next()) {
			broj_kartice[brojac]=result.getInt("Broj_kartice");
			brojac++;
		}
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-korisnici");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}//zatvaranje parametara za komunaickju sa bazom
	}
	
}public static void pohrana_ime() {//pohrana imena iz baze 
	//isti nacin kao i sa pohranom sifre kartice
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="Select Ime from Baza_korisnika  ";
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();
		int brojac=0;
		while (result.next()) {
			ime[brojac]=result.getString("Ime");
			brojac++;
		}
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-korisnici");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}//zatvaranje parametara za komunaickju sa bazom
	}
	
	
}public static void pohrana_prezime() {//pohrana prezimena iz baze 
	//isti nacin kao i sa pohranom sifre kartice
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="Select Prezime from Baza_korisnika  ";
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();
		int brojac=0;
		while (result.next()) {
			prezime[brojac]=result.getString("Prezime");
			brojac++;
		}
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-korisnici");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}//zatvaranje parametara za komunaickju sa bazom
	}
	
}public static void pohrana() {//pozivanje metoda pohrane i nizove 
	pohrana_ime();
	pohrana_prezime();
	pohrana_broja_kartice();
	pohrana_sifre_kartice();
	Baza_racuna.pohrana_racuna();
}
}
