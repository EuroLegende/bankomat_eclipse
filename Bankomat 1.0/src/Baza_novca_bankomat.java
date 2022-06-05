import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//problem u updatu baze novca moras dva puta update stisnut 
//i pronaci gresku sto izbacuje u konzoli za korisnike
public class Baza_novca_bankomat {
static int deset=0;
static int dvadeset=0;
static int pedeset=0;
static int sto=0;
static int dvjesto=0;
//deklaracija novcanica u bankomatu


static int ukupno_stanje=0;
//deklaracija ukupne vrijednosti novca u bankomatu sa kojom isti radi

public static void popuna_baze () {//provjera stanja u konzoli
	
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="UPDATE  Bankomat_racun set Deset=?   ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, deset);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}try {String query ="UPDATE  Bankomat_racun set Dvadeset=?  ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, dvadeset);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}try {String query ="UPDATE  Bankomat_racun set Pedeset=?  ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, pedeset);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}try {String query ="UPDATE  Bankomat_racun set Sto=? ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, sto);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}try {String query ="UPDATE   Bankomat_racun set Dvjesto=?  ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, dvjesto);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}try {String query ="UPDATE  Bankomat_racun set Ukupno_Stanje=?  ";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, ukupno_stanje);//promjena stanja racuna u bazu

		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	
	
	System.out.println("Stanje u banci ");
	System.out.println("Ukupno stanje "+ukupno_stanje);
			System.out.println("Deset "+deset);
			System.out.println("Dvadeset "+dvadeset);
			System.out.println("Pedeset "+pedeset);
			System.out.println("Sto "+sto);
			System.out.println("Dvjesto "+dvjesto);
		//ispis stanja
			
}public static void popuna_nizova () {
	
	Connection conn=sqlConnect.dbConnection();
	
	PreparedStatement izraz=null;
	ResultSet result=null;
	try {String query ="Select Deset from Bankomat_racun   ";
		izraz=conn.prepareStatement(query);
		result=izraz.executeQuery();
		deset=result.getInt("Deset");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz_novac1");
	}finally {
		try {
		izraz.close();
		result.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
}
	try {String query ="Select Dvadeset from Bankomat_racun   ";
	izraz=conn.prepareStatement(query);
	result=izraz.executeQuery();
	dvadeset=result.getInt("Dvadeset");
} catch (Exception e) {
	System.out.println("Problem u bazi, kriv uslov, izraz_novac2");
}finally {
	try {
	izraz.close();
	result.close();
} catch (Exception e) {
	// TODO: handle exception
}
}
	
	try {String query ="Select Pedeset from Bankomat_racun   ";
	izraz=conn.prepareStatement(query);
	result=izraz.executeQuery();
	pedeset=result.getInt("Pedeset");
} catch (Exception e) {
	System.out.println("Problem u bazi, kriv uslov, izraz_novac3");
}finally {
	try {
	izraz.close();
	result.close();
} catch (Exception e) {
	// TODO: handle exception
}
}
	try {String query ="Select Sto from Bankomat_racun   ";
	izraz=conn.prepareStatement(query);
	result=izraz.executeQuery();
	sto=result.getInt("Sto");
} catch (Exception e) {
	System.out.println("Problem u bazi, kriv uslov, izraz_novac4");
}finally {
	try {
	izraz.close();
	result.close();
} catch (Exception e) {
	// TODO: handle exception
}
}
	try {String query ="Select Dvjesto from Bankomat_racun   ";
	izraz=conn.prepareStatement(query);
	result=izraz.executeQuery();
	dvjesto=result.getInt("Dvjesto");
} catch (Exception e) {
	System.out.println("Problem u bazi, kriv uslov, izraz_novac5");
}finally {
	try {
	izraz.close();
	result.close();
} catch (Exception e) {
	// TODO: handle exception
}
}
	
}public static void pohrana_stanja() {
	ukupno_stanje=10*deset+dvadeset*20+pedeset*50+sto*100+dvjesto*200;
Connection conn=sqlConnect.dbConnection();


	PreparedStatement izraz=null;
	ResultSet result=null;
	
		try {	
			String query ="UPDATE  Bankomat_racun   set Ukupno_stanje=?";//uslov u bazu
		izraz=conn.prepareStatement(query);
		izraz.setInt(1, ukupno_stanje);
		izraz.execute();
		//komunikacij sa bazm
		System.out.println("Uspjela konekcija sa racunom i promjena stanja racuna");
	} catch (Exception e) {
		System.out.println("Problem u bazi, kriv uslov, izraz-racun");
	}finally {
		try {
			izraz.close();
			result.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
}
}
