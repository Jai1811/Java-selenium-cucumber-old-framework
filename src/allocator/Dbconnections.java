package allocator;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnections {
	public static Connection mysqlconnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/flight?";
		String username = "user=root&password=root";
		// String password="root";
		Connection conn = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + username);
			System.out.println("Connected to database successfully");

		} catch (Exception e) {
			System.out.println("Could not connect to database");
		}
		return conn;

	}
}
