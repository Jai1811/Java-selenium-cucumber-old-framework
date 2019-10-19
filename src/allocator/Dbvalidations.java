package allocator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Dbvalidations {

	public static String extractsqldata(String tablename, String columnname) throws SQLException {
		Connection conn = null;
		String fieldvalue = null;
		if (tablename.equals("air_flight_details")) {
			conn = Dbconnections.mysqlconnection();
			String sql = "Select * from " + tablename;
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				fieldvalue = rs.getString(columnname);
				System.out.println(fieldvalue);
			}
		}
		return fieldvalue;
	}

	public static void sqlmethod() throws SQLException {
		Connection conn = null;
		conn = Dbconnections.mysqlconnection();
		String sql = "select f.flight_id,f.from_location,f.to_location,monthname(fd.flight_departure_date) as 			Month_name,avg(fd.price) as Average_price from air_flight f join air_flight_details fd on f.flight_id=fd.flight_id 			group by f.flight_id,Month_name order by f.flight_id,Month_name";

		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			HashMap<String, String> tablevalue = new HashMap<>();
			tablevalue.put("f.flight_id", rs.getString("f.flight_id"));
			tablevalue.put("f.from_location", rs.getString("f.from_location"));
			tablevalue.put("Month_name", rs.getString("Month_name"));
			tablevalue.put("Average_price", rs.getString("Average_price"));
			System.out.println(tablevalue);
		}

	}

}
