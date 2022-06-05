import java.sql.*;
import javax.swing.*;

public class sqlConnect {Connection conn=null;
public static Connection dbConnection () {
	Connection conn=null;
	try {
		Class.forName("org.sqlite.JDBC");
		conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Documents\\kodovi\\Sql.db");
		System.out.println("Konekcija sa bazom uspostavljena");
	
	} catch (Exception e) {
		
		System.out.println("Konekcije nema");
	}
	return conn;
}
}
