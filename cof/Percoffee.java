package cof;
import java.sql.Connection;
import java.sql.DriverManager;

public class Percoffee {
	public Connection getDBConnection() {
		Connection con = null ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee","root","");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return con;
	}

	public Connection getDBConnection1() {

		// TODO Auto-generated method stub

		return null;

	}

}




